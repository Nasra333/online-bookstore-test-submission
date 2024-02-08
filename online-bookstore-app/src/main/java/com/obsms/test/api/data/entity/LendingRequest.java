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
import com.obsms.test.api.abs.RequestStatus;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import com.obsms.test.api.converter.RequestStatusConverter;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * @author walles
 */

@Getter
@Setter
@Entity
@Table(name = "lending_request", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"tracking_number"})})
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LendingRequest extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "tracking_number", nullable = false, length = 50)
    @JsonProperty("tracking_number")
    private String trackingNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    @JsonProperty("status")
    @Convert(converter = RequestStatusConverter.class)
    private RequestStatus status;
    @JoinColumn(name = "users", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonProperty("user")
    private Users user;
    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "lendingRequest", fetch = FetchType.EAGER)
    @JsonProperty("record")
    private LendingRecord record;
    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lendingRequest", fetch = FetchType.EAGER)
    @JsonProperty("request_line_items")
    private List<LendingRequestLineItem> requestLineItems;

    /**
     * default constructor.
     */
    public LendingRequest() {
    }

    public LendingRequest(String trackingNumber, RequestStatus status, Users user, LendingRecord record) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.user = user;
        this.record = record;
    }

    public LendingRequest(String trackingNumber, RequestStatus status, Users user, LendingRecord record,
                          List<LendingRequestLineItem> requestLineItems, String id, Long version, Date createdDate,
                          Date lastModifiedDate, boolean active, boolean newEntity, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.trackingNumber = trackingNumber;
        this.status = status;
        this.user = user;
        this.record = record;
        this.requestLineItems = requestLineItems;
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
        return "LendingRequest{" +
                "trackingNumber='" + trackingNumber + '\'' +
                ", status=" + status +
                ", id='" + id + '\'' +
                '}';
    }
}
