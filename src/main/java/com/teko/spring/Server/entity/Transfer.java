package com.teko.spring.Server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Transfer")
public class Transfer {
    private String id;
    private Tx tx;

    public Transfer() {
    }

    public Transfer(String id, Tx tx) {
        this.id = id;
        this.tx = tx;
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

}
