package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "resident")
@PrimaryKeyJoinColumn(name = "residentid")
public class Resident extends Individual {

    /*
        The property this person lives in
        Many residents can live in one property
    */
    @ManyToOne(optional = false)
    @JoinColumn(name = "property_code")
    private Property property;

    /*
        When the person started living there
    */
    @Column(name = "residency_start_date", nullable = false)
    private LocalDate residencyStartDate;

    /*
        True if this resident is also the homeowner
    */
    @Column(name = "is_owner_resident", nullable = false)
    private boolean ownerResident;

    protected Resident() {}

    public Resident(
            Property property,
            LocalDate residencyStartDate,
            boolean ownerResident
    ) {
        this.property = property;
        this.residencyStartDate = residencyStartDate;
        this.ownerResident = ownerResident;
    }

    public Property getProperty() {
        return property;
    }

    public LocalDate getResidencyStartDate() {
        return residencyStartDate;
    }

    public boolean isOwnerResident() {
        return ownerResident;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setResidencyStartDate(LocalDate residencyStartDate) {
        this.residencyStartDate = residencyStartDate;
    }

    public void setOwnerResident(boolean ownerResident) {
        this.ownerResident = ownerResident;
    }
}
