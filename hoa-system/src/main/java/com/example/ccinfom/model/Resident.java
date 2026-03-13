package com.example.ccinfom.model;

import java.time.LocalDateTime;
import java.util.Objects;

/*
Table: resident

Business Rules:
1. residentid is both the PRIMARY KEY and FOREIGN KEY referencing individual(individualid)
   → A resident must already exist as an Individual.
2. renter indicates whether the resident is renting the property.
3. rel_homeowner describes the relationship between the resident and homeowner.
4. authorized indicates if the resident is authorized by the homeowner.
5. last_update must be updated annually for ID issuance eligibility (enforced in service layer).
*/

public class Resident {

    private Integer residentid;
    private boolean renter;
    private String rel_homeowner;
    private boolean authorized;
    private LocalDateTime last_update;

    public Resident() {}

    public Resident(Integer residentid,
                    boolean renter,
                    String rel_homeowner,
                    boolean authorized,
                    LocalDateTime last_update) {
        this.residentid = residentid;
        this.renter = renter;
        this.rel_homeowner = rel_homeowner;
        this.authorized = authorized;
        this.last_update = last_update;
    }

    public Integer getResidentid() {
        return residentid;
    }

    public void setResidentid(Integer residentid) {
        this.residentid = residentid;
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

    public boolean isAuthorized() {
        return authorized;
    }

    public void setAuthorized(boolean authorized) {
        this.authorized = authorized;
    }

    public LocalDateTime getLast_update() {
        return last_update;
    }

    public void setLast_update(LocalDateTime last_update) {
        this.last_update = last_update;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resident resident = (Resident) o;
        return Objects.equals(residentid, resident.residentid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(residentid);
    }
}
