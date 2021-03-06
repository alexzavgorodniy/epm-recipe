package com.epm.recipe.web_ui.controller;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.service.RecipeService;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class RestRecipeController {

    private final RecipeService recipeService;

    public RestRecipeController(RecipeService recipeService) {
        this.recipeService = Objects.requireNonNull(recipeService, "recipeService");
    }

    @GetMapping("recipe_of_the_day")
    public Recipe recipeOfTheDay() {
        return recipeService.recipeOfTheDay();
    }

    @GetMapping("recipe")
    public List<Recipe> findAllRecipes() {
        return recipeService.findAll();
    }

    @GetMapping("recipe/{id}")
    public Recipe findOneById(@PathVariable Long id) {
        return recipeService.findOneById(id);
    }

    @PostMapping("recipe")
    public void createRecipe(@RequestBody Recipe recipe) {
        recipeService.create(recipe);
    }

    @PutMapping("recipe/{id}")
    public void updateRecipe(@PathVariable Long id, @RequestBody Recipe recipe) {
        recipe.setId(id);
        recipeService.update(recipe);
    }

    @DeleteMapping("recipe/{id}")
    public void deleteRecipe(@PathVariable Long id) {
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipeService.delete(recipe);
    }
}