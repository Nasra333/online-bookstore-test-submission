/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.obsms.test.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 *
 * @author Ikram Samaad
 */
@Configuration
public class JsonTemplateViewConfiguration {

    @Bean
    public View jsonView() {
        MappingJackson2JsonView mappingView = new MappingJackson2JsonView();
        mappingView.setPrettyPrint(true);
        return mappingView;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }
}
