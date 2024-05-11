package com.learningexpress.exmaple.msd.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PostgresSqlDataSourceConfig {
    @ConfigurationProperties("spring.datasource.pg")
    @Bean
    public DataSourceProperties getPostgresDataSourceProperties(){
       return   new DataSourceProperties();
    }

    @Bean
    public DataSource getPostgresDataSource(){
        return getPostgresDataSourceProperties().initializeDataSourceBuilder().build();
    }
}
