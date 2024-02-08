package com.obsms.test.api.commons.config;

import java.util.Set;

/**
 * Application start-up configuration base interface.
 *
 * @author Ikram Samaad.
 */
public interface IStartUpConfiguration {

    /**
     * @return {@link Set}
     */
    Set<String> getActiveProfiles();

    /**
     * @return {@link String}
     */
    String getUrlContextPath();

    /**
     * @return {@link String}
     */
    boolean isSecure();

    /**
     *
     * @return {@link String}
     */
    String getUserHome();
}
