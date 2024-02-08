package com.obsms.test.api.commons.abs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * abstract class interface handler for {@link ResponseEntity} notifications.
 *
 * @author Ikram Samaad.
 * @see IBasicErrorHandler
 * @see IErrorHandler
 * @see ResponseEntity
 */
public abstract class AbstractBasicErrorHandler<T extends Exception> implements IBasicErrorHandler<T> {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected Map<String, List<String>> targetMap = new HashMap<>();
    @Autowired
    protected HttpServletRequest request;

    /**
     * @param request
     * @param e
     */
    protected void logError(HttpServletRequest request, Exception e) {
        StringBuilder requestDescription = new StringBuilder("Error sending ")
                .append(request.getMethod())
                .append(" request to ")
                .append(request.getRequestURI());
        if (!StringUtils.isEmpty(request.getQueryString())) {
            requestDescription.append(" with query: ").append(request.getQueryString());
        }
        requestDescription.append(". Error: ");
        error(requestDescription.toString() + e.getMessage(), e);
    }

    /**
     * @param message
     * @param throwable
     */
    protected void error(String message, Throwable throwable) {
        LOGGER.error(message, throwable);
    }

    /**
     * @param key
     * @param values
     */
    protected void addTarget(String key, String... values) {
        List<String> list = new ArrayList<>(Arrays.asList(values));
        targetMap.put(key, list);
    }
}
