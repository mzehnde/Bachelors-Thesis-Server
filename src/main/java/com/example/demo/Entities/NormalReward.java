package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "NormalReward")
public class NormalReward {
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

    @Column(name = "Description")
    private String Description;




    public NormalReward(String name) {
        this.Name = name;
    }

    public NormalReward() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPartner() {
        return Partner;
    }

    public void setPartner(String partner) {
        Partner = partner;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        this.Image = image;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        this.Location = location;
    }


}
