package com.example.demo.REST;

public class NFTRedeemPutDTO {
    private int sales;
    private int id;

    public NFTRedeemPutDTO() {
    }

    public NFTRedeemPutDTO(int sales, int id) {
        this.sales = sales;
        this.id = id;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
