package com.teko.spring.Server.entity;

public class Src {
    private String cls;
    private String phone_number;
    private String operator;

    public Src() {
    }

    public Src(String cls, String phone_number, String operator) {
        this.cls = cls;
        this.phone_number = phone_number;
        this.operator = operator;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }
}
