package com.epm.recipe.service.impl.config;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.persistence.EntityDao;
import com.epm.recipe.persistence.RecipeRepository;
import com.epm.recipe.service.impl.DefaultRecipeService;

import com.epm.recipe.service.impl.RecipeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {

    @Bean
    public DefaultRecipeService recipeService(RecipeRepository recipeRepository) {
        return new DefaultRecipeService(recipeRepository);
    }

    @Bean
    public RecipeServiceImpl recipeServiceImpl(EntityDao<Recipe> recipeDao) {
        return new RecipeServiceImpl(recipeDao);
    }
}
