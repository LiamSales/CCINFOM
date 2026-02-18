package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "property")
public class Property {

    @Id
    @Column(name = "property_code", length = 6)
    private String propertyCode;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "homeownerid", nullable = false)
    private Homeowner homeowner_homeownerid; // should this be an int?

    @Positive
    @Column(name = "size", nullable = false)
    private int size;

    @Column(name = "turnover_date")
    private LocalDate turnover_date;

    protected Property() {}

    public Property(
            String propertyCode,
            Homeowner homeowner,
            int size,
            LocalDate turnover_date
    ) {
        this.propertyCode = propertyCode;
        this.homeowner = homeowner;
        this.size = size;
        this.turnover_date = turnover_date;
    }

    public String getPropertyCode() {
        return propertyCode;
    }

    public Homeowner getHomeowner() {
        return homeowner;
    }

    public int getSize() {
        return size;
    }

    public LocalDate getTurnover_date() {
        return turnover_date;
    }

    public void setHomeowner(Homeowner homeowner) {
        this.homeowner = homeowner;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setTurnover_date(LocalDate turnover_date) {
        this.turnover_date = turnover_date;
    }
}
