
package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractAddonAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 *
 * @author ope
 */

@Getter
@Setter
@Entity
@Table(name = "lending_request_line_item")
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class LendingRequestLineItem extends AbstractAddonAuditable {

    @JoinColumn(name = "book", referencedColumnName = "id", nullable = false, insertable = true, updatable = true)
    @OneToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonProperty("book")
    private Book book;
    @JsonBackReference
    @JoinColumn(name = "lending_request", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonProperty("lending_request")
    private LendingRequest lendingRequest;

    /**
     * default constructor.
     */
    public LendingRequestLineItem() {
    }

    /**
     * constructor.
     *
     * @param book
     * @param lendingRequest
     */
    public LendingRequestLineItem(Book book, LendingRequest lendingRequest) {
        this.book = book;
        this.lendingRequest = lendingRequest;
    }

    /**
     * constructor.
     *
     * @param book
     * @param lendingRequest
     */
    public LendingRequestLineItem(Book book, LendingRequest lendingRequest, String id, Long version, boolean newEntity, Date createdDate,
                                  Date lastModifiedDate, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.book = book;
        this.lendingRequest = lendingRequest;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
        this.newEntity = newEntity;
    }

    @Override
    public String toString() {
        return "LendingRequestLineItem{" +
                "book=" + book +
                ", lendingRequest=" + lendingRequest +
                '}';
    }
}
