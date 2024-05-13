/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author walles
 */

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"})})
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username", nullable = false, length = 100)
    @JsonProperty("username")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password", nullable = false, length = 50)
    @JsonProperty("password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "fullname", nullable = false, length = 150)
    @JsonProperty("fullname")
    private String fullname;
    @OneToOne(cascade = {CascadeType.ALL}, mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private UserBrowseHistory browseHistory;

    public Users() {
    }

    public Users(String userName, String password, String fullname,
                 RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
    }

    public Users(String userName, String password, String fullname, String id, Long version,
                 Date createdDate, Date lastModifiedDate, boolean active, boolean newEntity, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.userName = userName;
        this.password = password;
        this.fullname = fullname;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
        this.active = active;
        this.newEntity = newEntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public UserBrowseHistory getBrowseHistory() {
        return browseHistory;
    }

    public void setBrowseHistory(UserBrowseHistory browseHistory) {
        this.browseHistory = browseHistory;
    }

    @Override
    public String toString() {
        return "Users{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
