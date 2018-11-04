package com.epm.recipe.service.impl;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.persistence.EntityDao;
import com.epm.recipe.service.EntityService;
import java.util.List;

public class RecipeServiceImpl implements EntityService<Recipe> {

    private EntityDao<Recipe> recipeDao;

    public RecipeServiceImpl(EntityDao<Recipe> recipeDao) {
        this.recipeDao = recipeDao;
    }

    @Override
    public List<Recipe> findAll() {
        return recipeDao.findAll();
    }

    @Override
    public Recipe findOneById(Long id) throws IllegalArgumentException {
        try {
            return recipeDao.findOneById(id);
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("There are no recipe with such ID!");
        }
    }

    @Override
    public void create(Recipe recipe) {
        if (isRecipeNull(recipe)) {
            recipeDao.create(recipe);
        }
    }

    @Override
    public Recipe update(Recipe newRecipe) throws IllegalArgumentException {
        Recipe oldRecipe = new Recipe();
        if (isRecipeNull(newRecipe)) {
            oldRecipe = findOneById(newRecipe.getId());
            recipeDao.update(newRecipe);
        }
        return oldRecipe;
    }

    @Override
    public Recipe delete(Recipe recipe) throws IllegalArgumentException {
        Recipe deletedRecipe = new Recipe();
        if (isRecipeNull(recipe)) {
            deletedRecipe = findOneById(recipe.getId());
            recipeDao.delete(recipe);
        }
        return deletedRecipe;
    }


    private boolean isRecipeNull(Recipe recipe) {
        return recipe != null;
    }
}