package com.example.demo.REST;

public class RewardPutDTO {
    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    public RewardPutDTO(String sales, String qrcodereward) {
        this.sales = sales;
        this.qrcodereward = qrcodereward;
    }

    private String sales;
    private String qrcodereward;

    public String getQrcodereward() {
        return qrcodereward;
    }

    public void setQrcodereward(String qrcodereward) {
        this.qrcodereward = qrcodereward;
    }
}
