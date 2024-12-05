package com.petquer.petquer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() {
        executeScript("sql/create_script_execution_status_table.sql");
        executeScript("sql/create.sql");
//        if (isScriptExecuted("procedures.sql")) {
//            executeScript("sql/procedures.sql");
//            markScriptAsExecuted("procedures.sql");
//        }
        executeScript("sql/views.sql");
        if (isScriptExecuted("populate.sql")) {
            executeScript("sql/populate.sql");
            markScriptAsExecuted("populate.sql");
        }
    }

    private boolean isScriptExecuted(String scriptName) {
    String sql = "SELECT COUNT(*) FROM script_execution_status WHERE script_name = ?";
    Integer count = jdbcTemplate.queryForObject(sql, Integer.class, scriptName);
    return count == null || count <= 0;
    }

    private void executeScript(String scriptPath) {
        ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
        resourceDatabasePopulator.addScript(new ClassPathResource(scriptPath));
        resourceDatabasePopulator.execute(dataSource);
    }

    private void markScriptAsExecuted(String scriptName) {
        String sql = "INSERT INTO script_execution_status (script_name) VALUES (?)";
        jdbcTemplate.update(sql, scriptName);
    }
}