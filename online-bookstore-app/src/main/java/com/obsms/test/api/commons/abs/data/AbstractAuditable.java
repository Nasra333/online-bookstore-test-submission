package com.obsms.test.api.commons.abs.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.Nullable;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

/**
 * @param <U>
 * @param <PK>
 * @author Ikram Sammad
 */
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractAuditable<U, PK extends Serializable>
        extends AbstractPersistable<PK>
        implements Persistable<PK>, Auditable<U, PK, Date> {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JsonProperty("created_by")
    protected U createdBy;

    @ManyToOne
    @JsonProperty("last_modified_by")
    protected @Nullable U lastModifiedBy;

    /**
     *
     * @return {@link Optional}
     */
    @Override
    public U getCreatedBy() {
        return createdBy;
    }

    /**
     *
     * @param createdBy the creating entity to set
     */
    @Override
    public void setCreatedBy(U createdBy) {
        this.createdBy = createdBy;
    }

    /**
     *
     * @return
     */
    @Override
    public U getLastModifiedBy() {
        return lastModifiedBy;
    }

    /**
     *
     * @param lastModifiedBy the last modifying entity to set
     */
    @Override
    public void setLastModifiedBy(U lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

}