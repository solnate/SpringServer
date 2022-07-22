package com.teko.spring.Server.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Client {
    private String id;
    private String showcase;

    public Client() {
    }

    public Client(String id, String showcase) {
        this.id = id;
        this.showcase = showcase;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShowcase() {
        return showcase;
    }

    public void setShowcase(String showcase) {
        this.showcase = showcase;
    }
}
