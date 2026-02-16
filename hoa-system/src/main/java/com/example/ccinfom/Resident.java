package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "resident")
@PrimaryKeyJoinColumn(name = "residentid")
public class Resident extends Individual {

    // @ManyToOne(optional = false)
    // @JoinColumn(name = "property_code")
    // private Property property;


    @Column(name = "renter", nullable = false)
    private boolean renter;

    @Column(name = "mobilenum", length = 45)
    private String mobilenum;

    @Column(name = "rel_homeowner", length = 45)
    private String rel_homeowner;


    protected Resident() {}

    public Resident(
            boolean renter,
            String mobilenum,
            String rel_homeowner
    ) {
        this.renter = renter;
        this.mobilenum = mobilenum;
        this.rel_homeowner = rel_homeowner;
    }

    public boolean isRenter() {
        return renter;
    }

    public String getMobilenum() {
        return mobilenum;
    }

    public String getRel_homeowner() {
        return rel_homeowner;
    }

    // public void setProperty(Property property) {
    //     this.property = property;
    // }


    public void setRenter(boolean renter) {
        this.renter = renter;
    }

    public void setMobilenum(String mobilenum) {
        this.mobilenum = mobilenum;
    }

    public void setRel_homeowner(String rel_homeowner) {
        this.rel_homeowner = rel_homeowner;
    }

}
