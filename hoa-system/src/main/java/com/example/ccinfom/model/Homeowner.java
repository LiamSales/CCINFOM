package com.example.ccinfom.model;

import java.time.LocalDate;

public class Homeowner extends Individual {

    private Integer homeownerid;
    private LocalDate residency_start;
    private boolean membership;
    private boolean isresident;

    public Homeowner() {}

    public Homeowner(
            Integer homeownerid,
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking,
            LocalDate residency_start,
            boolean membership,
            boolean isresident
    ) {
        super(lastname, firstname, mi, birthday, gender, email, undertaking);
        this.homeownerid = homeownerid;
        this.residency_start = residency_start;
        this.membership = membership;
        this.isresident = isresident;
    }

    public Integer getHomeownerid() {
        return homeownerid;
    }

    public void setHomeownerid(Integer homeownerid) {
        this.homeownerid = homeownerid;
    }

    public LocalDate getResidency_start() {
        return residency_start;
    }

    public void setResidency_start(LocalDate residency_start) {
        this.residency_start = residency_start;
    }

    public boolean isMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public boolean isIsresident() {
        return isresident;
    }

    public void setIsresident(boolean isresident) {
        this.isresident = isresident;
    }
}