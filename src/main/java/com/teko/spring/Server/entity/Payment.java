package com.teko.spring.Server.entity;

public class Payment {
    private int amount;
    private int currency;
    private  int exponent;

    public Payment() {
    }

    public Payment(int amount, int currency, int exponent) {
        this.amount = amount;
        this.currency = currency;
        this.exponent = exponent;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }
}
