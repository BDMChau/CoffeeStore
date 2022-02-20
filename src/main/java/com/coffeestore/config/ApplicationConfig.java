//package com.coffeestore.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.multipart.MultipartResolver;
//import org.springframework.web.multipart.commons.CommonsMultipartResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "com.coffeestore")
//public class ApplicationConfig implements WebMvcConfigurer {
//    // this file is like application.properties in Spring Boot
//
//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(10240000);
//        return multipartResolver;
//    }
//
//    /////////////////// private methods ///////////////////
//
//
//}
