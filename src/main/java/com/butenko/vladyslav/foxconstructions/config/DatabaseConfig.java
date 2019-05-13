package com.butenko.vladyslav.foxconstructions.config;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.butenko.vladyslav.foxconstructions.repository")
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.model")
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.driver.url}")
    private String jdbcUrl;

    @Value("${database.host.ip}")
    private String hostIp;

    @Value("${database.host.port}")
    private String hostPort;

    @Value("${database.name}")
    private String databaseName;

    @Value("${database.timezone}")
    private String timezone;

    @Value("${database.use-ssl}")
    private boolean useSsl;

    @Value("${database.use-unicode}")
    private boolean useUnicode;

    @Value("${database.character-encoding}")
    private String encoding;

    @Value("${database.username}")
    private String username;

    @Value("${database.password}")
    private String password;

    @Value("${hibernate.show-sql}")
    private boolean showSql;

    @Value("${hibernate.generate-ddl}")
    private boolean generateDdl;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Value("${hibernate.entity-packages}")
    private String entityPackages;

    @Bean
    public JpaTransactionManager transactionManager(final EntityManagerFactory factory) {
        return new JpaTransactionManager(factory);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            DataSource dataSource, HibernateJpaVendorAdapter jpaVendorAdapter) {
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource);
        factory.setJpaVendorAdapter(jpaVendorAdapter);
        factory.setPackagesToScan(entityPackages);
        return factory;

    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(getDatasourceUrl());
        dataSource.setConnectionProperties(getConnectionProperties());
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }


    @Bean
    public HibernateJpaVendorAdapter hibernateJpaVendorAdapter() {
        final HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        adapter.setGenerateDdl(generateDdl);
        adapter.setShowSql(showSql);
        adapter.setDatabasePlatform(dialect);
        return adapter;
    }


    private String getDatasourceUrl() {
        return this.jdbcUrl + "://" + this.hostIp + ":" +
                this.hostPort + "/" + this.databaseName;
    }

    private String getConnectionProperties() {
        return "serverTimezone=" + this.timezone + ";" +
                "useUnicode=" + this.useUnicode + ";" +
                "useSSL" + this.useSsl + ";" +
                "characterEncoding" + this.encoding + ";";
    }

}
