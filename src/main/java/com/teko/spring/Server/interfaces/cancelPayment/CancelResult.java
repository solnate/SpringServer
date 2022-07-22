package com.teko.spring.Server.interfaces.cancelPayment;

import com.teko.spring.Server.entity.Tx;

public class CancelResult {
    private Tx tx;

    public CancelResult() {
    }

    public CancelResult(Tx tx) {
        this.tx = tx;
    }

    public Tx getTx() {
        return tx;
    }

    public void setTx(Tx tx) {
        this.tx = tx;
    }
}
