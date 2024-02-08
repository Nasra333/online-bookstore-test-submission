package com.obsms.test.api.config;

import com.obsms.test.api.commons.config.AbstractSwaggerApiConfig;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger UI/Open ApI configuration/request filter interface.
 *
 * @author Ikram Samaad
 */
@Configuration
public class OpenApiSwaggerConfig extends AbstractSwaggerApiConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("OnlineBookStoreServiceApi")
                .displayName("Online Bookstore Service Api")
                .packagesToScan("com.obsms.test.api.endpoint")
                .build();
    }

}