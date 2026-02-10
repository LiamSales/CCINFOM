package com.example.ccinfom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;

@Entity
public class Homeowner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(0)
    private int yearsAsHomeowner;

    @Past
    private LocalDate birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Email
    private String primaryEmail;

    @ElementCollection
    @CollectionTable(
        name = "homeowner_mobile_numbers",
        joinColumns = @JoinColumn(name = "homeowner_id")
    )
    @Column(name = "mobile_number")
    private List<String> mobileNumbers = new ArrayList<>();

    private String facebookUrl;

    private String pictureUrl;

    private boolean undertaking;

    private boolean expression;

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection
    @CollectionTable(
        name = "homeowner_other_emails",
        joinColumns = @JoinColumn(name = "homeowner_id")
    )
    @Column(name = "email")
    private List<String> otherEmails = new ArrayList<>();

    protected Homeowner(){}

    public Homeowner(
            String name,
            int yearsAsHomeowner,
            LocalDate birthday,
            Gender gender,
            String primaryEmail,
            boolean undertaking,
            boolean expression
    ) {
        this.name = name;
        this.yearsAsHomeowner = yearsAsHomeowner;
        this.birthday = birthday;
        this.gender = gender;
        this.primaryEmail = primaryEmail;
        this.undertaking = undertaking;
        this.expression = expression;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getYearsAsHomeowner() {
        return yearsAsHomeowner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public List<String> getMobileNumbers() {
        return mobileNumbers;
    }

    public List<String> getOtherEmails() {
        return otherEmails;
    }

    public String getFacebookUrl() {
        return facebookUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public boolean isUndertaking() {
        return undertaking;
    }

    public boolean isExpression() {
        return expression;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYearsAsHomeowner(int yearsAsHomeowner) {
        this.yearsAsHomeowner = yearsAsHomeowner;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    public void setFacebookUrl(String facebookUrl) {
        this.facebookUrl = facebookUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public void declareUndertaking() {
        this.undertaking = true;
    }

    public void expressMembershipIntent() {
        this.expression = true;
    }

    public void addMobileNumber(String number) {
        this.mobileNumbers.add(number);
    }

    public void addOtherEmail(String email) {
        this.otherEmails.add(email);
    }

    public void addProperty(Property property) {
        properties.add(property);
        property.setHomeowner(this);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
        property.setHomeowner(null);
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setHomeowner(this);
    }

    public void removeAddress(Address address) {
        addresses.remove(address);
        address.setHomeowner(null);
    }

    public boolean isOfLegalAge() {
        return birthday != null &&
               birthday.isBefore(LocalDate.now().minusYears(18));
    }
}
