package com.epm.recipe.persistence.in_memory.config;

import com.epm.recipe.persistence.in_memory.InMemoryRecipeRepository;

import com.epm.recipe.persistence.in_memory.RecipeDao;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class InMemoryPersistenceConfiguration {

    @Bean
    public InMemoryRecipeRepository recipeRepository() {
        return new InMemoryRecipeRepository();
    }

    @Bean
    public RecipeDao recipeDao(JdbcTemplate jdbcTemplate) {
        return new RecipeDao(jdbcTemplate);
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        Config instance = Config.getInstance();
        dataSource.setDriverClassName(instance.driver());
        dataSource.setUrl(instance.url());
        dataSource.setUsername(instance.user());
        dataSource.setPassword(instance.password());
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
