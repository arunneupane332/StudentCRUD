package com.example.CRUDOperation.Model;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "fname")
    private String fname;
    @Column(name = "lname")
    private String lname;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    private long phone;
    @Column(name = "rollNo")
    private String rollNo;
    @Column(name = "studies")
    private String Studies;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getStudies() {
        return Studies;
    }

    public void setStudies(String studies) {
        Studies = studies;
    }

    public Student(long id, String fname, String lname, String email, String address, long phone, String rollNo, String studies) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.rollNo = rollNo;
        Studies = studies;

    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone=" + phone +
                ", rollNo='" + rollNo + '\'' +
                ", Studies='" + Studies + '\'' +
                '}';
    }
}