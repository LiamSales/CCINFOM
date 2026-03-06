package com.example.ccinfom.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Individual {

    private Integer individualid;
    private String lastname;
    private String firstname;
    private String mi;
    private LocalDate birthday;
    private Gender gender;
    private String email;
    private String facebook_url;
    private String picture_filename;
    private boolean undertaking;

    private List<String> mobileNumbers = new ArrayList<>();

    public Individual() {}

    public Individual(
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking
    ) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.mi = mi;
        this.birthday = birthday;
        this.gender = gender;
        this.email = email;
        this.undertaking = undertaking;
    }

    public Integer getIndividualid() {
        return individualid;
    }

    public void setIndividualid(Integer individualid) {
        this.individualid = individualid;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMi() {
        return mi;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public String getPicture_filename() {
        return picture_filename;
    }

    public void setPicture_filename(String picture_filename) {
        this.picture_filename = picture_filename;
    }

    public boolean isUndertaking() {
        return undertaking;
    }

    public void setUndertaking(boolean undertaking) {
        this.undertaking = undertaking;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void addMobileNumber(String number) {
        this.mobileNumbers.add(number);
    }

    public void removeMobileNumber(String number) {
        this.mobileNumbers.remove(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Individual that)) return false;
        return Objects.equals(individualid, that.individualid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individualid);
    }

    /*
        Nested enum.
        Stored in SQL as CHAR(1) -> 'M' or 'F'
    */
    public enum Gender {

        M('M'),
        F('F');

        private final char code;

        Gender(char code) {
            this.code = code;
        }

        public char getCode() {
            return code;
        }

        public static Gender fromCode(char code) {
            for (Gender g : values()) {
                if (g.code == code) {
                    return g;
                }
            }
            throw new IllegalArgumentException("Invalid gender code: " + code);
        }
    }
}