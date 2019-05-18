package com.butenko.vladyslav.foxconstructions.config;


import com.butenko.vladyslav.foxconstructions.model.user.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.butenko.vladyslav.foxconstructions.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String ADMIN_REQUEST_URL = "/admin/**";

    private static final String MANAGER_REQUEST_URL = "/managers/**";

    private static final String ACCESS_DENIED_URL = "/exception";

    private static final String LOGIN_URL = "/login";

    private static final String USERNAME = "vlad";

    private static final String PASSWORD = "12345";

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .logout().invalidateHttpSession(false)
                .and()
                .authorizeRequests()
                .antMatchers(ADMIN_REQUEST_URL).hasRole(UserRole.ADMIN.name())
                .antMatchers(MANAGER_REQUEST_URL).hasAnyRole(UserRole.ADMIN.name(), UserRole.MANAGER.name())
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage(LOGIN_URL)
                .usernameParameter(USERNAME)
                .passwordParameter(PASSWORD)
                .defaultSuccessUrl("/", false)
                .and()
                .exceptionHandling().accessDeniedPage(ACCESS_DENIED_URL)
                .and()
                .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
}
