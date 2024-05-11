package com.learningexpress.exmaple.msd.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class MySqlDataSourceConfig {
    @ConfigurationProperties("spring.datasource.mysql")
    @Bean
    public DataSourceProperties getMySqlDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Primary
    @Bean
    public DataSource getMySqlDataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setUrl(getMySqlDataSourceProperties().getUrl());
//        dataSource.setUsername(getMySqlDataSourceProperties().getUsername());
//        dataSource.setPassword(getMySqlDataSourceProperties().getPassword());
//        dataSource.setDriverClassName(getMySqlDataSourceProperties().getDriverClassName());
//        return dataSource;
        return getMySqlDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
