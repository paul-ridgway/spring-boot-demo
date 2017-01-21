package io.ridgway.springdemo.layout;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LayoutInterceptor extends HandlerInterceptorAdapter {

    private static final String DEFAULT_LAYOUT = "layout/application";
    private static final String VIEW_ATTRIBUTE_NAME = "view";
    private static final String CONTROLLER_ATTRIBUTE_NAME = "controller";

    @Override
    public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
                           final ModelAndView modelAndView) throws Exception {
        if (modelAndView == null || !modelAndView.hasView()) {
            return;
        }
        final String originalViewName = modelAndView.getViewName();
        if (isRedirectOrForward(originalViewName)) {
            return;
        }
        final HandlerMethod handlerMethod = (HandlerMethod) handler;
        final String layoutName = getLayoutName(handlerMethod);
        modelAndView.setViewName(layoutName);
        modelAndView.addObject(VIEW_ATTRIBUTE_NAME, originalViewName);
        modelAndView.addObject(CONTROLLER_ATTRIBUTE_NAME, handlerMethod.getBeanType().getSimpleName());
    }

    private boolean isRedirectOrForward(final String viewName) {
        return viewName.startsWith("redirect:") || viewName.startsWith("forward:");
    }

    private String getLayoutName(final HandlerMethod handlerMethod) {
        final Layout layout = getLayoutAnnotation(handlerMethod);
        if (layout == null) {
            return DEFAULT_LAYOUT;
        } else {
            return layout.value();
        }
    }

    private Layout getLayoutAnnotation(final HandlerMethod handlerMethod) {
        final Layout layout = handlerMethod.getMethodAnnotation(Layout.class);
        if (layout == null) {
            return handlerMethod.getBeanType().getAnnotation(Layout.class);
        }
        return layout;
    }
}
