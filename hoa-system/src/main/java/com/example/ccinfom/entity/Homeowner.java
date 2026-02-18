package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "homeowner")
@PrimaryKeyJoinColumn(name = "homeownerid") 
public class Homeowner extends Individual {

    @Column(name = "residency_start")
    private LocalDate residencyStart;

    @Column(name = "membership", nullable = false)
    private boolean membership;

    @Column(name = "isresident", nullable = false)
    private boolean resident;

    protected Homeowner() {}

    public Homeowner(
            String lastname,
            String firstname,
            String mi,
            LocalDate birthday,
            Gender gender,
            String email,
            boolean undertaking,
            LocalDate residencyStart,
            boolean membership,
            boolean resident
    ) {
        super(lastname, firstname, mi, birthday, gender, email, undertaking);
        this.residencyStart = residencyStart;
        this.membership = membership;
        this.resident = resident;
    }

    public LocalDate getResidencyStart() {
        return residencyStart;
    }

    public void setResidencyStart(LocalDate residencyStart) {
        this.residencyStart = residencyStart;
    }

    public boolean isMembership() {
        return membership;
    }

    public void setMembership(boolean membership) {
        this.membership = membership;
    }

    public boolean isResident() {
        return resident;
    }

    public void setResident(boolean resident) {
        this.resident = resident;
    }
}
