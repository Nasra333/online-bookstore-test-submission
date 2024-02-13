package com.obsms.test.api.commons.abs.data;

import org.springframework.lang.Nullable;

import java.io.Serializable;

/**
 * @param <PK>
 * @author Ikram Samaad.
 */
public interface Persistable<PK> extends Serializable {

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
