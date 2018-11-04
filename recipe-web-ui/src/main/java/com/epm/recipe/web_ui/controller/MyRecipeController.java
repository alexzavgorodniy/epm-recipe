package com.epm.recipe.web_ui.controller;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.service.EntityService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyRecipeController {

    private final EntityService<Recipe> recipeService;

    public MyRecipeController(EntityService<Recipe> recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("success")
    public ModelAndView showSuccessPage() {
        return new ModelAndView("success");
    }

    @GetMapping("recipes")
    public ModelAndView showAllRecipes() {
        ModelAndView modelAndView = new ModelAndView("recipes");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes", recipes);
        return modelAndView;
    }

    @GetMapping("recipeById")
    public ModelAndView showOneById(@RequestParam(required = false) Long id) {
        ModelAndView modelAndView = new ModelAndView("recipeById");
        modelAndView.addObject("recipeSearch", new Recipe(0L, ""));
        Recipe recipeById = (id != null) ? recipeService.findOneById(id) : null;
        modelAndView.addObject("recipe", recipeById);
        return modelAndView;
    }

    @PostMapping("recipeById")
    public String processSelectedRecipe(@ModelAttribute Recipe recipeSearch) {
        return "redirect:recipeById?id=" + recipeSearch.getId();
    }

    @GetMapping("addRecipe")
    public ModelAndView showAddRecipePage() {
        ModelAndView modelAndView = new ModelAndView("addRecipe");
        modelAndView.addObject("addRecipe", new Recipe(""));
        return modelAndView;
    }

    @PostMapping("addRecipe")
    public String proceedNewRecipe(@ModelAttribute Recipe newRecipe) {
        recipeService.create(newRecipe);
        return "redirect:success";
    }

    @GetMapping("updateRecipe")
    public ModelAndView showUpdateRecipePage() {
        ModelAndView modelAndView = new ModelAndView("updateRecipe");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes", recipes);
        modelAndView.addObject("recipeUpdate", new Recipe(0L, ""));
        return modelAndView;
    }

    @PostMapping("updateRecipe")
    public String proceedUpdateRecipe(@ModelAttribute Recipe newRecipe) {
        try {
            recipeService.update(newRecipe);
            return "redirect:success";
        } catch (IllegalArgumentException e) {
            return "redirect:error?exceptionMessage=" + e.getMessage();
        }
    }

    @GetMapping("deleteRecipe")
    public ModelAndView showDeleteRecipePage() {
        ModelAndView modelAndView = new ModelAndView("deleteRecipe");
        List<Recipe> recipes = recipeService.findAll();
        modelAndView.addObject("recipes", recipes);
        modelAndView.addObject("recipeDelete", new Recipe(0L, ""));
        return modelAndView;
    }

    @PostMapping("deleteRecipe")
    public String proceedDeleteRecipe(@ModelAttribute Recipe recipeSearch) {
        try {
            recipeService.delete(recipeSearch);
            return "redirect:success";
        } catch (IllegalArgumentException e) {
            return "redirect:error?exceptionMessage=" + e.getMessage();
        }
    }

    @GetMapping("error")
    public ModelAndView showErrorPage(@RequestParam String exceptionMessage) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("exception", exceptionMessage);
        return modelAndView;
    }
}