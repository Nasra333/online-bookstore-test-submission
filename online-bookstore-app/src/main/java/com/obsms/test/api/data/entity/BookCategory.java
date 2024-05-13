package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author walles
 */

@Entity
@Table(name = "book_category", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"name"})})
@XmlRootElement
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookCategory extends AbstractActiveAuditable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name", nullable = false, length = 100)
    @JsonProperty("name")
    private String name;
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "bookCategory", fetch = FetchType.EAGER)
    @JsonManagedReference
    @JsonProperty("books")
    private List<Book> books = new ArrayList<>();

    public BookCategory() {
    }

    public BookCategory(String name, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.name = name;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
    }

    public BookCategory(String name, String id, Long version, Date createdDate, Date lastModifiedDate, boolean active, boolean newEntity, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.name = name;
        this.id = id;
        this.version = version;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
        this.active = active;
        this.newEntity = newEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "BookCategory{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
