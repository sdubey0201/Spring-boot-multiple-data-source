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
        basePackages = "com.learningexpress.exmaple.msd.mysqlentity",
        entityManagerFactoryRef ="getMySqlEntityManageFactoryBean",
        transactionManagerRef = "getMySqlTransactionManager"
)
public class MySqlEntityAndTransactionManagerConfiguration {

    @Bean
   public LocalContainerEntityManagerFactoryBean getMySqlEntityManageFactoryBean(EntityManagerFactoryBuilder entityManagerFactoryBuilder, @Qualifier("getMySqlDataSource") DataSource dataSource){
        return entityManagerFactoryBuilder
                .dataSource(dataSource)
                .packages("com.learningexpress.exmaple.msd.mysqlentity")
                .build();
    }

    @Bean
    public PlatformTransactionManager getMySqlTransactionManager(@Qualifier("getMySqlEntityManageFactoryBean") LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean){
        return new JpaTransactionManager(localContainerEntityManagerFactoryBean.getObject());
    }
}
