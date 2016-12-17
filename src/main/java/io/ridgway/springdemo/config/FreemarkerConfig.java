package io.ridgway.springdemo.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.TemplateException;
import io.ridgway.springdemo.utils.Environment;
import io.ridgway.springdemo.utils.ViewResourceLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.SpringTemplateLoader;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import java.io.IOException;

@Configuration
public class FreemarkerConfig {

    private static final Logger L = LoggerFactory.getLogger(FreemarkerConfig.class);

    private final Environment environment = new Environment();

    @Bean
    public ViewResolver viewResolver() {
        final FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setExposeSpringMacroHelpers(true);
        viewResolver.setExposeRequestAttributes(false);
        viewResolver.setExposeSessionAttributes(false);
        return viewResolver;
    }
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() throws IOException, TemplateException {
        L.info("Setting up FreeMarkerConfigurer, running in jar: {}", environment.isRunningInJar());
        final FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        final SpringTemplateLoader springTemplateLoader = createTemplateLoader();
        final ClassTemplateLoader baseMvcTplLoader = new ClassTemplateLoader(FreeMarkerConfigurer.class, "");
        final MultiTemplateLoader mtl = new MultiTemplateLoader(new TemplateLoader[]{springTemplateLoader, baseMvcTplLoader});
        configurer.setPostTemplateLoaders(mtl);
        configurer.setDefaultEncoding("UTF-8");
        configurer.setPreferFileSystemAccess(false);
        return configurer;
    }

    private SpringTemplateLoader createTemplateLoader() {
        return new ViewResourceLoader(environment.isRunningInJar()).createSpringTemplateLoader();
    }


}
