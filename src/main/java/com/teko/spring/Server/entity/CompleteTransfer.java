package com.teko.spring.Server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "CompleteTransfers")
public class CompleteTransfer {
    private String id;
    private Tx tx;
    private Payment payment;
    private Payment src_payment;

    public CompleteTransfer(String id, Tx tx, Payment payment, Payment src_payment) {
        this.id = id;
        this.tx = tx;
        this.payment = payment;
        this.src_payment = src_payment;
    }

    public CompleteTransfer() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Payment getSrc_payment() {
        return src_payment;
    }

    public void setSrc_payment(Payment src_payment) {
        this.src_payment = src_payment;
    }
}
