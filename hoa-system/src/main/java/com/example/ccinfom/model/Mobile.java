package com.example.ccinfom.model;
import java.util.Objects;

public class Mobile {

    private String mobileNumber;   // Primary Key
    private int individualId;      // Foreign Key

    public Mobile() {}

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mobile mobile = (Mobile) o;

        return Objects.equals(mobileNumber, mobile.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mobileNumber);
    }
}