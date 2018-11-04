package com.epm.recipe.persistence.in_memory;

import com.epm.recipe.persistence.in_memory.config.Config;
import com.epm.recipe.persistence.in_memory.exception.DaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DaoFactory {

    public DaoFactory() {
        try {
            Class.forName(Config.getInstance().driver());
        } catch (ClassNotFoundException e) {
            throw new DaoException(e.getLocalizedMessage(), e);
        }
    }

    Connection getConnection() {
        try {
            Config config = Config.getInstance();
            return DriverManager.getConnection(config.url(), config.user(), config.password());
        } catch (SQLException e) {
            throw new DaoException("Could not create SQL Connection", e);
        }
    }
}