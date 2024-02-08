package com.obsms.test.api.commons.abs.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractActiveAuditable extends AbstractAddonAuditable {

    private static final long serialVersionUID = 1L;

    /**
     * default constructor.
     */
    public AbstractActiveAuditable() {
        super();
    }

    @Column(name = "active", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Type(type = "org.hibernate.type.BooleanType")
    @JsonProperty("active")
    protected boolean active = Boolean.TRUE;
}
