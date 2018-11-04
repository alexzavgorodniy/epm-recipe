package com.epm.recipe.persistence.in_memory.dao.exception;

public class DaoException extends RuntimeException {

    public DaoException(String message, Throwable exception) {
        super(message, exception);
    }
}
