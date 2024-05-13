
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
    public LendingRequestLineItem(Book book, LendingRequest lendingRequest, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.book = book;
        this.lendingRequest = lendingRequest;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
    }
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LendingRequest getLendingRequest() {
        return lendingRequest;
    }

    public void setLendingRequest(LendingRequest lendingRequest) {
        this.lendingRequest = lendingRequest;
    }

    @Override
    public String toString() {
        return "LendingRequestLineItem{" +
                "book=" + book +
                ", lendingRequest=" + lendingRequest +
                '}';
    }
}
