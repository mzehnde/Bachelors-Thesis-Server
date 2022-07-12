package com.example.demo.Entities;

public class User {
    private String emailAddress;
    private String kindOfReward;

    public String getKindOfReward() {
        return kindOfReward;
    }

    public void setKindOfReward(String kindOfReward) {
        this.kindOfReward = kindOfReward;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public User(String emailAddress, String kindOfReward) {
        this.emailAddress = emailAddress;
        this.kindOfReward = kindOfReward;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
