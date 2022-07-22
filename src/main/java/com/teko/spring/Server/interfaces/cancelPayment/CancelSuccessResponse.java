package com.teko.spring.Server.interfaces.cancelPayment;

public class CancelSuccessResponse {
    private String success;
    private CancelResult result;

    public CancelSuccessResponse() {
    }

    public CancelSuccessResponse(String success, CancelResult result) {
        this.success = success;
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public CancelResult getResult() {
        return result;
    }

    public void setResult(CancelResult result) {
        this.result = result;
    }
}
