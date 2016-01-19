package com.github.tobilko.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {

    private final static Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);
    private final static String NAME = "dispatcher";
    private final static String PACKAGE = "com.github.tobilko.configuration";

    @Override
    public void onStartup(ServletContext context) throws ServletException {
        AnnotationConfigWebApplicationContext config = new AnnotationConfigWebApplicationContext();
        config.setConfigLocation(PACKAGE);
        context.addListener(new ContextLoaderListener(config));
        logger.debug("Configuration location has been changed to [{}]", PACKAGE);

        ServletRegistration.Dynamic dispatcher = context.addServlet(NAME, new DispatcherServlet(config));
        dispatcher.setLoadOnStartup(0);
        dispatcher.addMapping("/");
        logger.debug("The servlet [{}] has been added to the servlet context.", NAME);
    }

}