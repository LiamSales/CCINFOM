package com.example.ccinfom;

import java.math.BigDecimal;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payment")
public class Payment {

    /*
        OR number is BOTH:
        - Primary key
        - Foreign key to Resident_id.orno
    */
    @Id
    @Column(name = "orno")
    private Integer orno;

    @NotNull
    @DecimalMin("0.00")
    @Digits(integer = 3, fraction = 2) // fits DECIMAL(5,2)
    @Column(name = "amount", precision = 5, scale = 2, nullable = false)
    private BigDecimal amount;

    /*
        Link to Resident_id using same OR number
        Shared primary key mapping
    */
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "orno")
    private Resident_id residentIdRecord;

    protected Payment() {}

    public Payment(Integer orno, BigDecimal amount, Resident_id residentIdRecord) {
        this.orno = orno;
        this.amount = amount;
        this.residentIdRecord = residentIdRecord;
    }

    public Integer getOrno() {
        return orno;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Resident_id getResidentIdRecord() {
        return residentIdRecord;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setResidentIdRecord(Resident_id residentIdRecord) {
        this.residentIdRecord = residentIdRecord;
    }
}