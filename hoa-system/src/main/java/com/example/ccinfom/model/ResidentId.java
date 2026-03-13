package com.example.ccinfom.model;

import java.time.LocalDate;

public class ResidentId {

    private Integer cardNo;

    private LocalDate requestDate;
    private String requestReason;
    private LocalDate issueDate;

    private Integer homeownerId;
    private Integer orno;
    private Integer residentId;

    private Status status;

    public enum Status {
        A,
        L,
        C
    }

    public ResidentId() {}

    public Integer getCardNo() {
        return cardNo;
    }

    public void setCardNo(Integer cardNo) {
        this.cardNo = cardNo;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestReason() {
        return requestReason;
    }

    public void setRequestReason(String requestReason) {
        this.requestReason = requestReason;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public Integer getHomeownerId() {
        return homeownerId;
    }

    public void setHomeownerId(Integer homeownerId) {
        this.homeownerId = homeownerId;
    }

    public Integer getOrno() {
        return orno;
    }

    public void setOrno(Integer orno) {
        this.orno = orno;
    }

    public Integer getResidentId() {
        return residentId;
    }

    public void setResidentId(Integer residentId) {
        this.residentId = residentId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}