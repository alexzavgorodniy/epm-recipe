package com.epm.recipe.service;

import com.epm.recipe.domain.Recipe;
import java.util.List;

public interface EntityService<T> {

    List<T> findAll();

    T findOneById(Long id);

    void create(T t);

    Recipe update(T t);

    Recipe delete(T t);
}