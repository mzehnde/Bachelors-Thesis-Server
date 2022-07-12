package com.example.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NFTRewardRedeemed")
public class NFTRewardRedeemed {
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

    @Column(name = "Sales")
    private int Sales;

    public NFTRewardRedeemed(int id, String name, String image, String ifpsHash, String location, int sales) {
        Id = id;
        Name = name;
        Image = image;
        IfpsHash = ifpsHash;
        Location = location;
        Sales = sales;
    }

    public NFTRewardRedeemed() {
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

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getSales() {
        return Sales;
    }

    public void setSales(int sales) {
        Sales = sales;
    }
}
