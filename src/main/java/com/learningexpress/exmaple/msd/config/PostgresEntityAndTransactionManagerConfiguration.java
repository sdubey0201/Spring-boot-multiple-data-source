package com.learningexpress.exmaple.msd.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
        basePackages = "com.learningexpress.exmaple.msd.prostgresentity",
        entityManagerFactoryRef ="getPostgresEntityManageFactoryBean",
        transactionManagerRef = "getPostgresTransactionManager"
)
public class PostgresEntityAndTransactionManagerConfiguration {
    @Bean
    LocalContainerEntityManagerFactoryBean getPostgresEntityManageFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("getPostgresDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.learningexpress.exmaple.msd.prostgresentity")
                .build();
    }

    @Bean
    public PlatformTransactionManager getPostgresTransactionManager(@Qualifier("getPostgresEntityManageFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
