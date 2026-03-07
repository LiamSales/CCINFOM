package com.example.ccinfom.model;

public class Mobile {

    private String mobileNumber;
    private int individualId;

    public Mobile() {
    }

    public Mobile(String mobileNumber, int individualId) {
        this.mobileNumber = mobileNumber;
        this.individualId = individualId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getIndividualId() {
        return individualId;
    }

    public void setIndividualId(int individualId) {
        this.individualId = individualId;
    }
}