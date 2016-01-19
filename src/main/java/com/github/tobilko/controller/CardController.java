package com.github.tobilko.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CardController {

    @RequestMapping("/hello")
    public ModelAndView hello() {
        System.out.println(getClass().getName());
        String key = "AIzaSyBWVJ3mB7V93bGMP5ozS6R59zOC0qTY6BQ";

        return new ModelAndView("index", "message", "Hello world!");
    }

}