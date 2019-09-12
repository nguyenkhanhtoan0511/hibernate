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

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Type(type="yes_no")
    @Column(name = "isActive")
    private boolean isActive;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "dob")
    private Date dob;

    @Column(name = "address")
    private String address;

    @Column(name = "description")
    private String description;

    public Author(){}

    public Author(String firstName, String lastName, boolean is_active, Date dob, String address, String description) {
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

    public String getFirst_name() {
        return firstName;
    }

    public void setFirst_name(String firstName) {
        this.firstName = firstName;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String lastName) {
        this.lastName = lastName;
    }

    public boolean isIs_active() {
        return isActive;
    }

    public void setIs_active(boolean is_active) {
        this.isActive = is_active;
    }

    public Date getDate_of_birth() {
        return dob;
    }

    public void setDate_of_birth(Date dob) {
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
