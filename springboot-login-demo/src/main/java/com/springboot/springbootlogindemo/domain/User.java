package com.springboot.springbootlogindemo.domain;

import jakarta.persistence.*;

@Table(name = "user")
@Entity
public class User {
    // Note: The attribute names should be consistent with the field names in the database table
    // Primary key auto-increment int(10) corresponds to long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long uid;

    // Username attribute varchar corresponds to String
    private String uname;

    // Password attribute varchar corresponds to String
    private String password;

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
