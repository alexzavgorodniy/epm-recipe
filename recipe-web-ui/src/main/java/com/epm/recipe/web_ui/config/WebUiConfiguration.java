package com.epm.recipe.web_ui.config;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.service.EntityService;
import com.epm.recipe.service.RecipeService;
import com.epm.recipe.web_ui.controller.ErrorController;
import com.epm.recipe.web_ui.controller.IndexController;
import com.epm.recipe.web_ui.controller.MyRestRecipeController;
import com.epm.recipe.web_ui.controller.RecipeController;
import com.epm.recipe.web_ui.controller.MyRecipeController;
import com.epm.recipe.web_ui.controller.RestRecipeController;
import com.epm.recipe.web_ui.controller.SuccessController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import(ThymeleafConfiguration.class)
public class WebUiConfiguration {

    @Bean
    RestRecipeController restRecipeController(RecipeService recipeService) {
        return new RestRecipeController(recipeService);
    }

    @Bean
    RecipeController recipeController(RecipeService recipeService) {
        return new RecipeController(recipeService);
    }

    @Bean
    MyRecipeController myRecipeController(EntityService<Recipe> recipeService) {
        return new MyRecipeController(recipeService);
    }

    @Bean
    MyRestRecipeController myRestRecipeController(EntityService<Recipe> recipeService) {
        return new MyRestRecipeController(recipeService);
    }

    @Bean
    IndexController indexController() {
        return new IndexController();
    }

    @Bean
    SuccessController successController(EntityService<Recipe> recipeService) {
        return new SuccessController(recipeService);
    }

    @Bean
    ErrorController errorController() {
        return new ErrorController();
    }
}
