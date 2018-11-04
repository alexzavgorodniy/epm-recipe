package com.epm.recipe.web_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController {

    @GetMapping("error")
    public ModelAndView showErrorPage(@RequestParam String exceptionMessage) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exceptionMessage);
        return modelAndView;
    }
}