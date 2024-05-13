package com.obsms.test.api.commons.abs.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Objects;

@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractAddonAuditable
        extends AbstractAuditable<RepositoryAuditUser, String>
        implements IBaseEntity<String> {

    private static final long serialVersionUID = 1L;

    @JsonProperty("new_entity")
    protected boolean newEntity;

    /**
     * default constructor.
     */
    public AbstractAddonAuditable() {
    }

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
        if (!(o instanceof AbstractAddonAuditable)) return false;
        AbstractAddonAuditable that = (AbstractAddonAuditable) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
