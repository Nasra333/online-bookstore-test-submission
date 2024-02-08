package com.obsms.test.api.commons.config;

import com.obsms.test.api.service.impl.AppStartUpConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Abstract facade interface for Swagger UI/Open ApI configuration/request filter.
 *
 * @see GroupedOpenApi
 * @see WebMvcConfigurer
 */
public abstract class AbstractSwaggerApiConfig implements WebMvcConfigurer {

    protected static final String SWAGGER_PATH = "api-docs/swagger-config";
    protected static final String SWAGGER_PROFILE = "swaggerui";

    @Autowired
    protected AppStartUpConfiguration start;

    public abstract GroupedOpenApi api();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SwaggerViewHandlerInterceptor());
    }

    /**
     * private support inner {@link HandlerInterceptor} interface implementation.
     *
     * @author Ikram Samaad.
     * @see HandlerInterceptor
     */
    private class SwaggerViewHandlerInterceptor implements HandlerInterceptor {

        @Override
        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
            final String s = request.getRequestURL().toString();
            if (s.contains(SWAGGER_PATH) && !start.getActiveProfiles().contains(SWAGGER_PROFILE)) {
                response.sendRedirect(String.format("%s/swagger-no-access.html", request.getContextPath()));
                return false;
            }
            return true;
        }
    }

}