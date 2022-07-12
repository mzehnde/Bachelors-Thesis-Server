package com.example.demo.REST;

public class NFTGetDTO {
    private int id;
    private String ifpsHash;

    public NFTGetDTO(int id, String ifpsHash) {
        this.id = id;
        this.ifpsHash = ifpsHash;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHash() {
        return ifpsHash;
    }

    public void setHash(String ifpsHash) {
        this.ifpsHash = ifpsHash;
    }
}
