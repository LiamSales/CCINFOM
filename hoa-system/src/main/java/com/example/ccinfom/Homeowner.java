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

    //how does this work
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

    protected Homeowner() {
        // Required by JPA and Jackson
    }

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

    public boolean isUndertaking() {
        return undertaking;
    }

    public boolean isExpression() {
        return expression;
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
