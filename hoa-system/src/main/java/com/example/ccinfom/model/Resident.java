package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "resident")
@PrimaryKeyJoinColumn(name = "residentid")
public class Resident extends Individual {

    @Column(name = "renter", nullable = false)
    private boolean renter;

    @Column(name = "rel_homeowner", length = 45)
    private String rel_homeowner;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "householdid", nullable = false)
    private Household household;

    @Column(name = "authorized", nullable = false)
    private boolean authorized;

    protected Resident() {}

    public Resident(
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking,
            boolean renter,
            String rel_homeowner,
            Household household,
            boolean authorized
    ) {
        super(lastname, firstname, mi, birthday, gender, email, undertaking);
        this.renter = renter;
        this.rel_homeowner = rel_homeowner;
        this.household = household;
        this.authorized = authorized;
    }

    public boolean isRenter() {
        return renter;
    }

    public String getRel_homeowner() {
        return rel_homeowner;
    }

    public Household getHousehold() {
        return household;
    }

    public boolean isAuthorized() {
        return authorized;
    }

    public void setRenter(boolean renter) {
        this.renter = renter;
    }

    public void setRel_homeowner(String rel_homeowner) {
        this.rel_homeowner = rel_homeowner;
    }

    public void setHousehold(Household household) {
        this.household = household;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }
}