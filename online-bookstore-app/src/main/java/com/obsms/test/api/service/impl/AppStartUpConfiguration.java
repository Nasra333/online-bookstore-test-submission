package com.obsms.test.api.service.impl;

import com.obsms.test.api.commons.config.IStartUpConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

/**
 * Application start-up configuration facade interface.
 *
 * @author Ikram Samaad.
 */
@Service
@Scope("singleton")
public class AppStartUpConfiguration implements IStartUpConfiguration {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppStartUpConfiguration.class);

    @Autowired
    private Environment environment;
    private final Set<String> activeProfiles = new HashSet<>();

    @PostConstruct
    private void LoadActiveProfile() {
        for (String profileName : environment.getActiveProfiles()) {
            activeProfiles.add(profileName);
        }
    }

    @Override
    public Set<String> getActiveProfiles() {
        return activeProfiles;
    }

    @Value("${config.drone.url_context_path}")
    private String urlContextPath;
    @Value("${config.drone.secure}")
    private boolean secure;
    @Value("${user_home}")
    private String userHome;

    @Override
    public String getUrlContextPath() {
        return urlContextPath;
    }

    @Override
    public boolean isSecure() {
        return secure;
    }

    @Override
    public String getUserHome() {
        return userHome;
    }
}
