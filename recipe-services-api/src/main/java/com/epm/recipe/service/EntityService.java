package com.epm.recipe.service;

import java.util.List;

public interface EntityService<T> {

    List<T> findAll();

    T findOneById(Long id);

    void create(T t);

    T update(T t);

    T delete(T t);
}