/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author walles
 */

@Getter
@Setter
@Entity
@Table(name = "user_browse_history")
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserBrowseHistory extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = true)
    @NotNull
    @Column(name = "history", nullable = true)
    @JsonProperty("history")
    private String history;
    @JoinColumn(name = "users", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonBackReference
    @JsonProperty("user")
    private Users user;

    public UserBrowseHistory() {
    }

    public UserBrowseHistory(String history, Users user) {
        this.history = history;
        this.user = user;
    }

    public UserBrowseHistory(String history, Users user, String id, Long version, Date createdDate, Date lastModifiedDate,
                             boolean active, boolean newEntity, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.history = history;
        this.user = user;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
        this.active = active;
        this.newEntity = newEntity;
    }

    @Override
    public String toString() {
        return "UserBroseHistory{" +
                "history='" + history + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
