package com.teko.spring.Server.entity.isPaymentPossible;

import com.teko.spring.Server.entity.Payment;
import com.teko.spring.Server.entity.Tx;

public class Result {
    private Tx tx;
    private Payment src_payment;
    private String rate;

    public Result() {
    }

    public Result(Tx tx, Payment src_payment, String rate) {
        this.tx = tx;
        this.src_payment = src_payment;
        this.rate = rate;
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }

    public Payment getSrc_payment() {
        return src_payment;
    }

    public void setSrc_payment(Payment src_payment) {
        this.src_payment = src_payment;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
