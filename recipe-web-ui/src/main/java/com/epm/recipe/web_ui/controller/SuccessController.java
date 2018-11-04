package com.epm.recipe.web_ui.controller;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.service.EntityService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SuccessController {

    private final EntityService<Recipe> recipeService;

    public SuccessController(EntityService<Recipe> recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("success")
    public ModelAndView showSuccessPage() {
        ModelAndView modelAndView = new ModelAndView("success");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes", recipes);
        return modelAndView;
    }
}