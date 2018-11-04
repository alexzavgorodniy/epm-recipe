package com.epm.recipe.web_ui.controller;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.service.EntityService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class MyRestRecipeController {

    private final EntityService<Recipe> recipeService;

    public MyRestRecipeController(EntityService<Recipe> recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("recipes")
    public List<Recipe> findAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("recipeById")
    public Recipe findOneById(@RequestParam Long id) {
        return recipeService.findOneById(id);
    }

    @PostMapping("createRecipe")
    public void createRecipe(@RequestBody Recipe recipe) {
        recipeService.create(recipe);
    }

    @PutMapping("updateRecipe")
    public void updateRecipe(@RequestBody Recipe recipe) {
        recipeService.update(recipe);
    }

    @DeleteMapping("deleteRecipe")
    public void deleteRecipe(@RequestBody Recipe recipe) {
        recipeService.delete(recipe);
    }
}