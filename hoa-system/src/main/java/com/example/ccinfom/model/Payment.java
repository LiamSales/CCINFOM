package com.example.ccinfom.model;

import java.math.BigDecimal;

public class Payment {

    private Integer orno;
    private BigDecimal amount;

    public Payment() {}

    public Integer getOrno() {
        return orno;
    }

    public void setOrno(Integer orno) {
        this.orno = orno;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}