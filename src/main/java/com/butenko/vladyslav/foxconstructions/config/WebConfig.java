package com.butenko.vladyslav.foxconstructions.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.butenko.vladyslav.foxconstructions.config",
        "com.butenko.vladyslav.foxconstructions.controller"})
@PropertySource("classpath:view.properties")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Value("${view.name-prefix}")
    private String viewPrefix;

    @Value("${view.name-suffix}")
    private String viewSuffix;

    @Value("${view.expose-beans-as-attributes}")
    private boolean exposeBeans;

    @Value("${resources.url}")
    private String resourceUrl;

    @Value("${resources.location}")
    private String resourceLocation;

    @Value("${login.url}")
    private String loginUrl;

    @Value("${login.view}")
    private String loginView;

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(this.viewPrefix);
        resolver.setSuffix(this.viewSuffix);
        resolver.setViewClass(JstlView.class);
        resolver.setExposeContextBeansAsAttributes(this.exposeBeans);
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(this.resourceUrl).addResourceLocations(this.resourceLocation);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(this.loginUrl).setViewName(this.loginView);
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
