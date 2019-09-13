package com.toan.nokia.hibernate.entity;

import org.hibernate.annotations.Type;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Author")
public class Author {

//    id : long
//    firstName : str
//    lastName : str
//    is_active : boolean
//    dob : date time
//    address : str
//    description : str

    private static final boolean IS_ACTIVE = true;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Type(type="yes_no")
    @Column(name = "is_active")
    private boolean isActive;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "Author", cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author(){}

    public Author(String firstName, String lastName, Date dob, String address, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.isActive = IS_ACTIVE;
        this.dob = dob;
        this.address = address;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", is_active=" + isActive +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
