package com.dst.subaccounting.postgre.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean(name="postgre")
    @Autowired
    public JdbcTemplate postgreSQLJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
