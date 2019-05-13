package com.butenko.vladyslav.foxconstructions.config;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
@EnableJpaRepositories(basePackages = "com.butenko.vladyslav.foxconstructions.repository")
@EnableTransactionManagement
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.model")
public class RootConfig {

    @Bean
    public BeanPostProcessor persistenceExceptionsTranslator() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }
}
