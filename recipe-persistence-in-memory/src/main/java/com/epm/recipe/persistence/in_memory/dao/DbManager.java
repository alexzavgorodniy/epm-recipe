package com.epm.recipe.persistence.in_memory.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.SQLException;
import org.h2.tools.RunScript;

public class DbManager {

    private static final String CREATE_TABLE_SCRIPT = "sql/create_table.sql";
    private static final String INSERT_DATA_SCRIPT = "sql/insert_data.sql";

    private void executeScript(String script) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        try (InputStream stream = classLoader.getResourceAsStream(script);
                InputStreamReader reader = new InputStreamReader(stream)) {
            RunScript.execute(new DaoFactory().getConnection(), reader);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        executeScript(CREATE_TABLE_SCRIPT);
    }

    public void insertData() {
        executeScript(INSERT_DATA_SCRIPT);
    }
}