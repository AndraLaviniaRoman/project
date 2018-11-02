package edu.codespring.blog.servlet;

import freemarker.template.Configuration;

import javax.enterprise.inject.Produces;

public class FreemarkerFactory {
    public static final String VIEWS_PACKAGE = "views";

    private static Configuration freemarkerConfiguration;

    @Produces
    public Configuration createFreemarkerConfiguration() {
        if (freemarkerConfiguration == null) {
            freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
            ClassLoader classLoader = FreemarkerFactory.class.getClassLoader();
            freemarkerConfiguration.setClassLoaderForTemplateLoading(classLoader, VIEWS_PACKAGE);
        }
        return freemarkerConfiguration;
    }

    public static Configuration getFreemarkerConfiguration() {
        if (freemarkerConfiguration == null) {
            freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
            ClassLoader classLoader = FreemarkerFactory.class.getClassLoader();
            freemarkerConfiguration.setClassLoaderForTemplateLoading(classLoader, VIEWS_PACKAGE);
        }
        return freemarkerConfiguration;
    }
}
