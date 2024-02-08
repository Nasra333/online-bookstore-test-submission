package com.obsms.test.api.commons.abs.data;

import org.springframework.lang.Nullable;

/**
 * @param <PK>
 * @author Ikram Samaad.
 */
public interface Persistable<PK> {

    /**
     * @return {@link PK}
     */
    @Nullable
    PK getId();

    /**
     * @return {@link Boolean}
     */
    boolean isNewEntity();

    /**
     * @return {@link Long}
     */
    Long getVersion();

    /**
     * @param version
     */
    void setVersion(Long version);
}
