package com.example.ccinfom;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "resident_id")
public class Resident_id {

    @Id
    @Column(name = "cardno")
    private Integer cardno;

    @Past
    @Column(name = "request_date", nullable = false)
    private LocalDate request_date;

    @Size(max = 45)
    @Column(name = "request_reason", length = 45)
    private String request_reason;

    @Past
    @Column(name = "issue_date")
    private LocalDate issue_date;

    @Size(max = 45)
    @Column(name = "hoa_officer", length = 45)
    private String hoa_officer;

    @Size(max = 45)
    @Column(name = "orno", length = 45)
    private String orno;

    /*
        Many resident IDs can belong to one resident
        (unless your rules say otherwise)
        DB column: residentid INT FK
    */
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "residentid", nullable = false)
    private Resident resident;

    @Enumerate_d(EnumType.STRING)
    @Column(name = "status", length = 1, nullable = false)
    private ResidentIdStatus status;

    protected Resident_id() {}

    public Resident_id(
            Integer cardno,
            LocalDate request_date,
            String request_reason,
            LocalDate issue_date,
            String hoa_officer,
            String orno,
            Resident resident,
            ResidentIdStatus status
    ) {
        this.cardno = cardno;
        this.request_date = request_date;
        this.request_reason = request_reason;
        this.issue_date = issue_date;
        this.hoa_officer = hoa_officer;
        this.orno = orno;
        this.resident = resident;
        this.status = status;
    }


    public Integer getCardno() {
        return cardno;
    }

    public LocalDate getRequest_date() {
        return request_date;
    }

    public String getRequest_reason() {
        return request_reason;
    }

    public LocalDate getIssue_date() {
        return issue_date;
    }

    public String getHoa_officer() {
        return hoa_officer;
    }

    public String getOrno() {
        return orno;
    }

    public Resident getResident() {
        return resident;
    }

    public ResidentIdStatus getStatus() {
        return status;
    }

    public void setRequest_date(LocalDate request_date) {
        this.request_date = request_date;
    }

    public void setRequest_reason(String request_reason) {
        this.request_reason = request_reason;
    }

    public void setIssue_date(LocalDate issue_date) {
        this.issue_date = issue_date;
    }

    public void setHoa_officer(String hoa_officer) {
        this.hoa_officer = hoa_officer;
    }

    public void setOrno(String orno) {
        this.orno = orno;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public void setStatus(ResidentIdStatus status) {
        this.status = status;
    }
}