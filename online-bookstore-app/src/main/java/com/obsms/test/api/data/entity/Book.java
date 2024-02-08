/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author walles
 */

@Getter
@Setter
@Entity
@Table(name = "book", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    @JsonProperty("name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "author", nullable = false, length = 150)
    @JsonProperty("author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "detail", nullable = false, length = 500)
    @JsonProperty("detail")
    private String detail;
    @Basic(optional = true)
    @Column(name = "image", nullable = true)
    @Lob
    @JsonProperty("image")
    private String image = "";
    @Column(name = "available", columnDefinition = "BOOLEAN NOT NULL DEFAULT TRUE")
    @Type(type = "org.hibernate.type.BooleanType")
    @JsonProperty("available")
    private boolean available = Boolean.TRUE;
    @JoinColumn(name = "book_category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonBackReference
    @JsonProperty("book_category")
    private BookCategory bookCategory;

    public Book() {
    }

    public Book(String name, String author, String detail, boolean available,
                BookCategory bookCategory, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.name = name;
        this.author = author;
        this.detail = detail;
        this.available = available;
        this.bookCategory = bookCategory;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
    }

    public Book(String name, String author, String detail, boolean available,
                BookCategory bookCategory, String id, Long version, Date createdDate,
                Date lastModifiedDate, boolean active, boolean newEntity, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.name = name;
        this.author = author;
        this.detail = detail;
        this.available = available;
        this.bookCategory = bookCategory;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
        this.active = active;
        this.newEntity = newEntity;
    }


    @JsonProperty("book_category")
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
