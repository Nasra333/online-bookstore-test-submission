package com.obsms.test.api.commons.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractAddonPersistable;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "repository_audit_user")
@JsonIgnoreProperties(ignoreUnknown = true)
public final class RepositoryAuditUser extends AbstractAddonPersistable {

    public RepositoryAuditUser() {
    }

    public RepositoryAuditUser(String auditorType, String auditorName) {
        this.auditorType = auditorType;
        this.auditorName = auditorName;
    }

    public RepositoryAuditUser(String auditorType, String auditorName, String id,
                               Long version, Date createdDate, Date lastModifiedDate, boolean active) {
        this.auditorType = auditorType;
        this.auditorName = auditorName;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }

    @Basic(optional = false)
    @NotNull
    @Column(name = "auditor_type")
    @JsonProperty("auditor_type")
    private String auditorType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "auditor_name")
    @JsonProperty("auditor_name")
    private String auditorName;
}