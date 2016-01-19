package com.github.tobilko.controller;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@RequestMapping("/cards")
public class CardController extends WebMvcConfigurerAdapter {

    private static final Logger logger = LoggerFactory.logger(CardController.class);

}