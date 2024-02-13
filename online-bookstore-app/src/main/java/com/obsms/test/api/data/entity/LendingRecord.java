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
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author walles
 */

@Entity
@Table(name = "lending_record")
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LendingRecord extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    @JsonProperty("return_date")
    private Date returnDate;
    @Column(name = "returned", columnDefinition = "BOOLEAN NOT NULL DEFAULT FALSE")
    @Type(type = "org.hibernate.type.BooleanType")
    @JsonProperty("returned")
    private boolean returned = Boolean.FALSE;
    @JsonBackReference
    @JoinColumn(name = "lending_request", referencedColumnName = "id", nullable = false)
    @OneToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    private LendingRequest lendingRequest;

    public LendingRecord() {
    }

    public LendingRecord(Date returnDate, boolean returned, LendingRequest lendingRequest) {
        this.returnDate = returnDate;
        this.returned = returned;
        this.lendingRequest = lendingRequest;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public LendingRequest getLendingRequest() {
        return lendingRequest;
    }

    public void setLendingRequest(LendingRequest lendingRequest) {
        this.lendingRequest = lendingRequest;
    }

    @Override
    public String toString() {
        return "LendingRecord{" +
                "returnDate=" + returnDate +
                ", returned=" + returned +
                ", id='" + id + '\'' +
                '}';
    }
}
