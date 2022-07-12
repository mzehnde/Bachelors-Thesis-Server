package com.example.demo.Entities;

import javax.persistence.*;

@Entity
@Table(name = "NormalRewardRedeemed")
public class NormalRewardRedeemed {
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

    @Column(name = "Sales")
    private int Sales;

    public NormalRewardRedeemed() {
    }

    public NormalRewardRedeemed(int id, String name, String image, String location, String partner, int sales) {
        Id = id;
        Name = name;
        Image = image;
        Location = location;
        Partner = partner;
        Sales = sales;
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

    public int getSales() {
        return Sales;
    }

    public void setSales(int sales) {
        Sales = sales;
    }
}