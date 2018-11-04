package com.epm.recipe.persistence.in_memory;

import com.epm.recipe.domain.Recipe;
import com.epm.recipe.persistence.EntityDao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class RecipeDao implements EntityDao<Recipe> {

    private JdbcTemplate jdbcTemplate;

    public RecipeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Recipe> findAll() {
        String sqlQuery = "SELECT * FROM recipes";
        return jdbcTemplate.queryForObject(sqlQuery,
                (resultSet, rowNumber) -> {
                    ArrayList<Recipe> recipes = new ArrayList<>();
                     do {
                        Recipe recipe = new Recipe(
                                resultSet.getLong(1),
                                resultSet.getString(2)
                                );
                        recipes.add(recipe);
                    } while (resultSet.next());
                    return recipes;
                });
    }

    @Override
    public Recipe findOneById(Long id) {
        String sqlQuery = "SELECT * FROM recipes WHERE id = ?";
        return jdbcTemplate.queryForObject(sqlQuery,
                (resultSet, rowNumber) -> new Recipe(
                        resultSet.getLong(1),
                resultSet.getString(2)),
                id);
    }

    @Override
    public void create(Recipe recipe) {
        String sqlQuery = "INSERT INTO recipes(title) VALUES (?)";
        jdbcTemplate.update(sqlQuery, recipe.getTitle());
    }

    @Override
    public void update(Recipe recipe) {
        String sqlQuery = "UPDATE recipes SET title = ? WHERE id = ?";
        jdbcTemplate.update(sqlQuery, recipe.getTitle(), recipe.getId());
    }

    @Override
    public void delete(Recipe recipe) {
        String sqlQuery = "DELETE FROM recipes WHERE id = ?";
        jdbcTemplate.update(sqlQuery, recipe.getId());
    }
}