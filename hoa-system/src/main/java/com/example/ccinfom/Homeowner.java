package com.example.ccinfom;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "homeowner")
@PrimaryKeyJoinColumn(name = "homeownerid")
public class Homeowner extends Individual {

    @Column(name = "residency_start")
    private LocalDate residency_start;


    @Column(name = "membership", nullable = false)
    private boolean membership;

    @Column(name = "isresident", nullable = false)
    private boolean resident;

    @OneToMany(
            mappedBy = "homeowner",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Property> properties = new ArrayList<>();

    protected Homeowner() {}

    public Homeowner(
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking,
            LocalDate residency_start,
            boolean membership,
            boolean resident
    ) {
        super(lastname, firstname, mi, birthday, gender, email, undertaking);
        this.residency_start = residency_start;
        this.membership = membership;
        this.resident = resident;
    }

    public LocalDate getResidency_start() {
        return residency_start;
    }

    public boolean isMembership() {
        return membership;
    }

    public boolean isResident() {
        return resident;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setResidency_start(LocalDate residency_start) {
        this.residency_start = residency_start;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }

    public void addProperty(Property property) {
        properties.add(property);
        property.setHomeowner(this);
    }

    public void removeProperty(Property property) {
        properties.remove(property);
        property.setHomeowner(null);
    }
}
