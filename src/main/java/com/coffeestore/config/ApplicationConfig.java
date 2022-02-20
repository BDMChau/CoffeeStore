package com.coffeestore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.coffeestore")
public class ApplicationConfig implements WebMvcConfigurer {
    // this file is like application.properties in Spring Boot

    @Bean(name = "sessionFactory")
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.coffeestore.model");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean(name = "dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/CoffeeStoreDb");
        dataSource.setUsername("postgres");
        dataSource.setPassword("1");

        return dataSource;
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(10240000);
        return multipartResolver;
    }

    /////////////////// private methods ///////////////////
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        hibernateProperties.setProperty("spring.jpa.generate-ddl", "true");
        hibernateProperties.setProperty("spring.jpa.hibernate.ddl-auto", "update");
        hibernateProperties.setProperty("spring.jpa.open-in-view", "false");
        hibernateProperties.setProperty("spring.jpa.show_sql", "true");
        hibernateProperties.setProperty("spring.jpa.properties.hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");

        return hibernateProperties;
    }
}
