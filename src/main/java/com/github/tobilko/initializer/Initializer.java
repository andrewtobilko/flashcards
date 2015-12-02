package com.github.tobilko.initializer;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Initializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext context) throws ServletException {
        ServletRegistration.Dynamic registration = context.addServlet("dispatcher", new DispatcherServlet());
        registration.setLoadOnStartup(1);
        registration.addMapping("/*");
    }
}
