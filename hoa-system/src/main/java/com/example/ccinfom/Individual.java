package com.example.ccinfom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity
@Table(name = "individual")
@Inheritance(strategy = InheritanceType.JOINED)
public class Individual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "individualid")
    private Integer individualid;

    @NotBlank
    @Column(name = "lastname", length = 45, nullable = false)
    private String lastname;

    @Column(name = "firstname", length = 45)
    private String firstname;

    @Column(name = "mi", length = 45)
    private String mi;

    @Past
    @Column(name = "birthday", nullable = false)
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 1)
    private Gender gender;

    @Email
    @Column(name = "email", length = 45)
    private String email;

    @Column(name = "facebook_url", length = 45)
    private String facebook_url;

    @Column(name = "pic_filename", length = 45)
    private String picture_filename;

    @Column(name = "undertaking", nullable = false)
    private boolean undertaking;

    /*
        Multiple mobile numbers per individual
        Stored in separate table:
            mobile
                mobilenum
                individualid (FK)
    */

    @ElementCollection
    @CollectionTable(
            name = "mobile",
            joinColumns = @JoinColumn(name = "individualid")
    )
    @Column(name = "mobilenum")
    private List<String> mobileNumbers = new ArrayList<>();

    protected Individual() {}

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

    public Integer getindividualId() {
        return individualid;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMi() {
        return mi;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getFacebook_url() {
        return facebook_url;
    }

    public String getPicturefilename() {
        return picture_filename;
    }

    public boolean isUndertaking() {
        return undertaking;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setMi(String mi) {
        this.mi = mi;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFacebook_url(String facebook_url) {
        this.facebook_url = facebook_url;
    }

    public void setPicture_filename(String picture_filename) {
        this.picture_filename = picture_filename;
    }

    public void setUndertaking(boolean undertaking) {
        this.undertaking = undertaking;
    }

    public void addMobileNumber(String number) {
        this.mobileNumbers.add(number);
    }

    public void removeMobileNumber(String number) {
        this.mobileNumbers.remove(number);
    }

    //----study this bottom part

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Individual that)) return false;
        return Objects.equals(individualId, that.individualId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individualId);
    }
}
