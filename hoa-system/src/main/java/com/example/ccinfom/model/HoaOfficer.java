package com.example.ccinfom.model;

import java.time.LocalDate;

public class HoaOfficer {

    private Integer homeownerid;
    private String hoaname;

    private String position;

    private LocalDate start_date;
    private LocalDate end_date;

    private LocalDate elec_date;
    private String elec_venue;
    private boolean elec_quorum;

    private String elec_witnessname;
    private Integer elec_witnessmobile;

    private String avail_Mon;
    private String avail_Tue;
    private String avail_Wed;
    private String avail_Thu;
    private String avail_Fri;
    private String avail_Sat;
    private String avail_Sun;

    public Integer getHomeownerid() {
        return homeownerid;
    }

    public void setHomeownerid(Integer homeownerid) {
        this.homeownerid = homeownerid;
    }

    public String getHoaname() {
        return hoaname;
    }

    public void setHoaname(String hoaname) {
        this.hoaname = hoaname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public LocalDate getElec_date() {
        return elec_date;
    }

    public void setElec_date(LocalDate elec_date) {
        this.elec_date = elec_date;
    }

    public String getElec_venue() {
        return elec_venue;
    }

    public void setElec_venue(String elec_venue) {
        this.elec_venue = elec_venue;
    }

    public boolean isElec_quorum() {
        return elec_quorum;
    }

    public void setElec_quorum(boolean elec_quorum) {
        this.elec_quorum = elec_quorum;
    }

    public String getElec_witnessname() {
        return elec_witnessname;
    }

    public void setElec_witnessname(String elec_witnessname) {
        this.elec_witnessname = elec_witnessname;
    }

    public Integer getElec_witnessmobile() {
        return elec_witnessmobile;
    }

    public void setElec_witnessmobile(Integer elec_witnessmobile) {
        this.elec_witnessmobile = elec_witnessmobile;
    }

    public String getAvail_Mon() {
        return avail_Mon;
    }

    public void setAvail_Mon(String avail_Mon) {
        this.avail_Mon = avail_Mon;
    }

    public String getAvail_Tue() {
        return avail_Tue;
    }

    public void setAvail_Tue(String avail_Tue) {
        this.avail_Tue = avail_Tue;
    }

    public String getAvail_Wed() {
        return avail_Wed;
    }

    public void setAvail_Wed(String avail_Wed) {
        this.avail_Wed = avail_Wed;
    }

    public String getAvail_Thu() {
        return avail_Thu;
    }

    public void setAvail_Thu(String avail_Thu) {
        this.avail_Thu = avail_Thu;
    }

    public String getAvail_Fri() {
        return avail_Fri;
    }

    public void setAvail_Fri(String avail_Fri) {
        this.avail_Fri = avail_Fri;
    }

    public String getAvail_Sat() {
        return avail_Sat;
    }

    public void setAvail_Sat(String avail_Sat) {
        this.avail_Sat = avail_Sat;
    }

    public String getAvail_Sun() {
        return avail_Sun;
    }

    public void setAvail_Sun(String avail_Sun) {
        this.avail_Sun = avail_Sun;
    }
}