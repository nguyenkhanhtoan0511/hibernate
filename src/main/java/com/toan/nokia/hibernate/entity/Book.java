package com.toan.nokia.hibernate.entity;


import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name="Book")
public class Book {

    private static final boolean IS_ACTIVE = true;

//    id : long
//    title : str
//    description : str
//    publicationDate : date time
//    price: float
//    author : Author
//    isActive:boolean

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "publicationDate")
    private Date publicationDate;

    @Column(name = "price")
    private float price;

    @Type(type="yes_no")
    @Column(name = "isActive")
    private boolean isActive;

    public Book(){}

    public Book(String title, String description, Date publicationDate, float price) {
        this.title = title;
        this.description = description;
        this.publicationDate = publicationDate;
        this.price = price;
        this.isActive = IS_ACTIVE;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublication_date() {
        return publicationDate;
    }

    public void setPublication_date(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", publicationDate=" + publicationDate +
                ", price=" + price +
                ", publicationDate=" + publicationDate +
                '}';
    }
}
