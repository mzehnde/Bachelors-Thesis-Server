package com.example.demo.REST;

public class NFTMailPutDTO {
    private String email;
    private int id;

    public NFTMailPutDTO() {
    }

    public NFTMailPutDTO(String email, int id) {
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
