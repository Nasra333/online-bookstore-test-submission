/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.obsms.test.api.config;

import org.javers.spring.auditable.AuthorProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author ope
 */
@Configuration
public class OBSMSAuditConfiguration {

    @Bean
    public AuthorProvider provideJaversAuthor() {
        return new OBSMSAuditAuthProvider();
    }
}

/**
 * private-package support interface.
 *
 * @author ope
 */
class OBSMSAuditAuthProvider implements AuthorProvider {

    @Override
    public String provide() {
        return "Bookstore";
    }
}
