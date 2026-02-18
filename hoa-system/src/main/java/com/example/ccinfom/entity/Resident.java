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

    protected Resident() {
        // required by JPA
    }

    public Resident(
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking,
            boolean renter,
            String mobilenum,
            String rel_homeowner
    ) {
        super(lastname, firstname, mi, birthday, gender, email, undertaking);
        this.renter = renter;
        this.rel_homeowner = rel_homeowner;
    }

    public boolean isRenter() {
        return renter;
    }

    public void setRenter(boolean renter) {
        this.renter = renter;
    }

    public String getRel_homeowner() {
        return rel_homeowner;
    }

    public void setRel_homeowner(String rel_homeowner) {
        this.rel_homeowner = rel_homeowner;
    }
}
