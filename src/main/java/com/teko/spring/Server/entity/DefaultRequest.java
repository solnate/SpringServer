package com.teko.spring.Server.entity;

public class DefaultRequest {
    private Client client;
    private String product;
    private Payment payment;
    private Payment src_payment;
    private String rate;
    private Src src;
    private Order order;
    private Tx tx;
    private Tx partner_tx;
    private String src_cls;
    private String tag;

    public DefaultRequest() {
    }

    public DefaultRequest(
            Client client, String product, Payment payment, Payment src_payment,
            String rate, Src src, Order order, Tx tx, Tx partner_tx) {
        this.client = client;
        this.product = product;
        this.payment = payment;
        this.src_payment = src_payment;
        this.rate = rate;
        this.src = src;
        this.order = order;
        this.tx = tx;
        this.partner_tx = partner_tx;
    }

    public DefaultRequest(Client client, String product, Payment payment, Order order, Src src, String tag) {
        this.client = client;
        this.product = product;
        this.payment = payment;
        this.order = order;
        this.src = src;
        this.tag = tag;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }

    public String getSrc_cls() {
        return src_cls;
    }

    public void setSrc_cls(String src_cls) {
        this.src_cls = src_cls;
    }

    public Src getSrc() {
        return src;
    }

    public void setSrc(Src src) {
        this.src = src;
    }

    public Tx getPartner_tx() {
        return partner_tx;
    }

    public void setPartner_tx(Tx partner_tx) {
        this.partner_tx = partner_tx;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
