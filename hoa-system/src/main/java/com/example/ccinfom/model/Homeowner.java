package com.example.ccinfom.model;

import java.time.LocalDate;

public class Homeowner extends Individual {

    private LocalDate residencyStart;
    private boolean membership;
    private boolean isResident;

    public Homeowner() {}

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
        return isResident;
    }

    public void setResident(boolean resident) {
        isResident = resident;
    }
}