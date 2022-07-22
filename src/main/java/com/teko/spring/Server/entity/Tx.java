package com.teko.spring.Server.entity;

public class Tx {
    private String id;
    private String start_t;

    public Tx() {
    }
    public Tx(String id, String start_t) {
        this.id = id;
        this.start_t = start_t;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStart_t() {
        return start_t;
    }

    public void setStart_t(String start_t) {
        this.start_t = start_t;
    }
}
