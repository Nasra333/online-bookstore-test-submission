package com.obsms.test.api.commons.abs.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

/**
 * @author Ikram Samaad.
 */
@MappedSuperclass
public abstract class AbstractAddonPersistable extends AbstractPersistable<String> {

    private static final long serialVersionUID = 1L;

    @JsonProperty("new_entity")
    protected boolean newEntity;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public boolean isNewEntity() {
        return newEntity = version == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAddonPersistable)) return false;
        AbstractAddonPersistable that = (AbstractAddonPersistable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
