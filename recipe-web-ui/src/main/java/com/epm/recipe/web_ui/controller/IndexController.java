package com.epm.recipe.web_ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/index")
    public ModelAndView shoeIndexPage() {
        return new ModelAndView("index");
    }

}