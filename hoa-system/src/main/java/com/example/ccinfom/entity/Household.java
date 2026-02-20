package com.example.ccinfom;

import jakarta.persistence.*;

@Entity
@Table(name = "household")
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "householdid")
    private Integer householdid;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
        name = "property_code",
        nullable = false,
        unique = true
    )
    private Property property;

    protected Household() {}

    public Household(Property property) {
        this.property = property;
    }

    public Integer getHouseholdid() {
        return householdid;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }
}
