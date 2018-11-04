package com.epm.recipe.domain;

import java.io.Serializable;
import java.util.Objects;

public class Recipe implements Serializable {

    private static final long serialVersionUID = 522604961379586814L;

    private Long id;

    private String title;

    public Recipe() {
    }

    public Recipe(String title) {
        this.title = Objects.requireNonNull(title, "title");
    }

    public Recipe(Long id, String title) {
        this.title = Objects.requireNonNull(title, "title");
        this.id = Objects.requireNonNull(id, "id");
    }

    public String getTitle() {
        return title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                '}';
    }
}
