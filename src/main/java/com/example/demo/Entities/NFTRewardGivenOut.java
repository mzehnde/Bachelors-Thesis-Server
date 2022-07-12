package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "NFTRewardGivenOut")
public class NFTRewardGivenOut {

    @Id
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Image")
    private String Image;

    @Column(name = "IfpsHash")
    private String IfpsHash;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Description")
    private String Description;

    public NFTRewardGivenOut(int id, String name, String image, String ifpsHash, String location, String description) {
        Id = id;
        Name = name;
        Image = image;
        IfpsHash = ifpsHash;
        Location = location;
        Description = description;
    }

    public NFTRewardGivenOut() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getIfpsHash() {
        return IfpsHash;
    }

    public void setIfpsHash(String ifpsHash) {
        IfpsHash = ifpsHash;
    }
}