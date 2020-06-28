package com.example.organdonationapp;

public class User {
    String name;
    String Email;
    String password;
    String address;
    String contact;
    String usertype;
    String bloodgroup;
    String organ;

    public User(){}

    public User(String name, String email, String password, String address, String contact, String usertype, String bloodgroup, String organ) {
        this.name = name;
        Email = email;
        this.password = password;
        this.address = address;
        this.contact = contact;
        this.usertype = usertype;
        this.bloodgroup = bloodgroup;
        this.organ = organ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getOrgan() {
        return organ;
    }

    public void setOrgan(String organ) {
        this.organ = organ;
    }
}
