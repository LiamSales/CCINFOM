package com.example.ccinfom;

import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

//Personal information and contact details
//Years as homeowner
//Owned properties within the subdivision
//Declaration of data accuracy and intent to become an HOA member
//Other addresses and contact information when not residing in the subdivision

@Entity
public class Homeowner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Min(0)
    private int yearsAsHomeowner;

    private boolean intentDeclared;

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Property> properties = new ArrayList<>();

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ContactInfo> contacts = new ArrayList<>();

    @OneToMany(mappedBy = "homeowner", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses = new ArrayList<>();

    protected Homeowner() {
        // Required by JPA and Jackson
    }

    public Homeowner(String name, int yearsAsHomeowner, boolean intentDeclared) {
        this.name = name;
        this.yearsAsHomeowner = yearsAsHomeowner;
        this.intentDeclared = intentDeclared;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

        public int getYearsAsHomeowner() {
        return yearsAsHomeowner;
    }
        public boolean isIntentDeclared() {
        return intentDeclared;

    }
        public void setIntentDeclared(boolean intentDeclared) {
        this.intentDeclared = intentDeclared;
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

    public void addContact(ContactInfo contact) {
        contacts.add(contact);
        contact.setHomeowner(this);
    }
    
    public void removeContact(ContactInfo contact) {
        contacts.remove(contact);
        contact.setHomeowner(null);
    }

}
