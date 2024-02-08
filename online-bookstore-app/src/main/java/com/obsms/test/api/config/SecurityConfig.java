package com.obsms.test.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Web security provider interface.
 *
 * @author Ikram Samaad.
 */
@Configuration
@EnableWebSecurity
@EnableAsync
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(new String[]{"/**", "/api/v1"})
                .permitAll();
        http.csrf().disable();
    }
}
