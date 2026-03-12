package com.example.ccinfom.model;

import java.time.LocalDate;

public class Property {

    private String propertyCode;
    private int homeownerId;

    private int size;
    private LocalDate turnoverDate;

    public Property() {}

    public String getPropertyCode() {
        return propertyCode;
    }

    public void setPropertyCode(String propertyCode) {
        this.propertyCode = propertyCode;
    }

    public int getHomeownerId() {
        return homeownerId;
    }

    public void setHomeownerId(int homeownerId) {
        this.homeownerId = homeownerId;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public LocalDate getTurnoverDate() {
        return turnoverDate;
    }

    public void setTurnoverDate(LocalDate turnoverDate) {
        this.turnoverDate = turnoverDate;
    }
}