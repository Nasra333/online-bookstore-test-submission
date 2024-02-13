package com.obsms.test.api.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.obsms.test.api.commons.abs.data.AbstractActiveAuditable;
import com.obsms.test.api.commons.data.entities.RepositoryAuditUser;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * @author walles
 */

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_name", nullable = false)
    private String categoryName;
    @JoinColumn(name = "book_category", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JsonBackReference
    private BookCategory bookCategory;

    public Book() {
    }

    public Book(String name, String author, String detail, String categoryName, boolean available,
                BookCategory bookCategory, RepositoryAuditUser createdBy, RepositoryAuditUser modifiedBy) {
        this.name = name;
        this.author = author;
        this.detail = detail;
        this.categoryName = categoryName;
        this.available = available;
        this.bookCategory = bookCategory;
        this.createdBy = createdBy;
        this.lastModifiedBy = modifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

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
                ", author='" + author + '\'' +
                ", detail='" + detail + '\'' +
                ", available=" + available +
                ", id='" + id + '\'' +
                '}';
    }
}
