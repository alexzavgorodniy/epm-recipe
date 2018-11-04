package com.epm.recipe.persistence;

import java.util.List;

public interface EntityDao<T> {

    List<T> findAll();

    T findOneById(Long id);

    void create(T t);

    void update(T t);

    void delete(T t);

}