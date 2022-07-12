package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "NormalRewardGivenOut")
public class NormalRewardGivenOut {
    @Id
    @Column(name = "Id")
    private int Id;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Image")
    private String Image;

    @Column(name = "Location")
    private String Location;

    @Column(name = "Partner")
    private String Partner;

    public NormalRewardGivenOut(int id, String name, String image, String location, String partner) {
        Id = id;
        Name = name;
        Image = image;
        Location = location;
        Partner = partner;
    }

    public NormalRewardGivenOut() {
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPartner() {
        return Partner;
    }

    public void setPartner(String partner) {
        Partner = partner;
    }
}