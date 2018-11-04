package com.epm.recipe.persistence.in_memory.config;

public enum Props {
    DRIVER("driver"),
    URL("url"),
    USER("username"),
    PASSWORD("password");

    private String key;

    Props(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
