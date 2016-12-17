package io.ridgway.springdemo.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.FileSystemResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.ui.freemarker.SpringTemplateLoader;

public class ViewResourceLoader implements ResourceLoader {

    private static final Logger L = LoggerFactory.getLogger(ViewResourceLoader.class);

    private static final String BASE_VIEW_PATH = "/views/";

    private final DefaultResourceLoader resourceLoader;
    private final boolean productionMode;

    public ViewResourceLoader(final boolean productionMode) {
        this.productionMode = productionMode;
        if (productionMode) {
            L.info("Creating using DefaultResourceLoader");
            resourceLoader = new DefaultResourceLoader();
        } else {
            L.info("Creating using FileSystemResourceLoader");
            resourceLoader = new FileSystemResourceLoader();
        }
    }

    @Override
    public Resource getResource(final String resource) {
        L.info("Resource Request: " + resource);
        return resourceLoader.getResource(resource);
    }

    @Override
    public ClassLoader getClassLoader() {
        return resourceLoader.getClassLoader();
    }

    public SpringTemplateLoader createSpringTemplateLoader() {
        if (productionMode) {
            return new SpringTemplateLoader(new ViewResourceLoader(productionMode), BASE_VIEW_PATH);
        } else {
            L.info("Creating FileSystemResourceLoader-based template loader");
            return new SpringTemplateLoader(new ViewResourceLoader(productionMode), webAppPath(BASE_VIEW_PATH));
        }
    }

    private String webAppPath(final String path) {
        return "file://" + System.getProperty("user.dir") + "/src/main/resources" + path;
    }

}
