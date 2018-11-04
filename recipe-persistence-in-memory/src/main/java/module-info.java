module recipe.persistence.in_memory {
    requires recipe.domain;
    requires recipe.persistence;
    requires spring.context;
    requires spring.jdbc;
    requires java.sql;
    requires org.mariadb.jdbc;
    requires h2;
    requires commons.dbcp;
    exports com.epm.recipe.persistence.in_memory.config;
    exports com.epm.recipe.persistence.in_memory.dao;
}