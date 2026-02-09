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

    @Past //validate must be age of majority
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
    private List<String> mobileNumbers = new ArrayList<>();

    private String facebookUrl;

    private String pictureUrl;

    private boolean intentDeclared;

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    protected Homeowner() {
        // Required by JPA and Jackson
    }

    public Homeowner(
            String name,
            int yearsAsHomeowner,
            LocalDate birthday,
            Gender gender,
            String primaryEmail,
            boolean intentDeclared
    ) {
        this.name = name;
        this.yearsAsHomeowner = yearsAsHomeowner;
        this.birthday = birthday;
        this.gender = gender;
        this.primaryEmail = primaryEmail;
        this.intentDeclared = intentDeclared;
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

    public boolean isIntentDeclared() {
        return intentDeclared;
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
}
