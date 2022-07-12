package com.example.demo.Entities;

public class NFTMail {
    private String email;
    private int id;

    public NFTMail() {
    }

    public NFTMail(String email, int id) {
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
