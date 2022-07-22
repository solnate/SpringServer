package com.teko.spring.Server.entity;

import com.google.gson.annotations.Expose;

public class Order {
    private Transaction transaction;
    private String cls;
    private Extra extra;

    public Order() {
    }

    public Order(String id, int start_t, int finish_t, String cls, String from, String some_key) {
        this.transaction = new Transaction(id, start_t, finish_t);
        this.cls = cls;
        this.extra = new Extra(from, some_key);
    }

    public Order(String id, int start_t, String cls, String from, String some_key) {
        this.transaction = new Transaction(id, start_t);
        this.cls = cls;
        this.extra = new Extra(from, some_key);
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public Extra getExtra() {
        return extra;
    }

    public void setExtra(Extra extra) {
        this.extra = extra;
    }

    public static class Extra{
        private String from;
        private String some_key;

        public Extra() {
        }

        public Extra(String from, String some_key) {
            this.from = from;
            this.some_key = some_key;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getSome_key() {
            return some_key;
        }

        public void setSome_key(String some_key) {
            this.some_key = some_key;
        }
    }
    public static class Transaction{
        private String id;
        private int start_t;
        @Expose(serialize = false)
        private int finish_t;

        public Transaction(String id, int start_t, int finish_t) {
            this.id = id;
            this.start_t = start_t;
            this.finish_t = finish_t;
        }

        public Transaction(String id, int start_t) {
            this.id = id;
            this.start_t = start_t;
        }

        public Transaction() {
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStart_t() {
            return start_t;
        }

        public void setStart_t(int start_t) {
            this.start_t = start_t;
        }

        public int getFinish_t() {
            return finish_t;
        }

        public void setFinish_t(int finish_t) {
            this.finish_t = finish_t;
        }
    }
}
