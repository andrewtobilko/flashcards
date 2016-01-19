package com.github.tobilko.configuration;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@EnableWebMvc
@Configuration
@ComponentScan({"com.github.tobilko"})
public class DependencyConfiguration extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(DependencyConfiguration.class);

    @Bean(name = "templateResolver")
    public ServletContextTemplateResolver getTemplateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();

        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");

        logger.debug("The ServletContextTemplateResolver instance has been configured and returned.");

        return resolver;
    }

    @Bean(name = "templateEngine")
    public SpringTemplateEngine getTemplateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(getTemplateResolver());

        logger.debug("The SpringTemplateEngine instance has been configured and returned.");

        return engine;
    }


    @Bean(name = "viewResolver")
    public ThymeleafViewResolver getViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(getTemplateEngine());

        logger.debug("The ThymeleafViewResolver instance has been configured and returned.");

        return resolver;
    }

}
