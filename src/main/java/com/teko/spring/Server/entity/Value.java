package com.teko.spring.Server.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Values")
public class Value {
    private int _id;
    private int amount;

    public Value() {
    }

    public Value(int _id, int amount) {
        this._id = _id;
        this.amount = amount;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
