package com.teko.spring.Server.entity.isPaymentPossible;

public class SuccessResponse {
    private String success;
    private Result result;

    public SuccessResponse() {
    }

    public SuccessResponse(String success, Result result) {
        this.success = success;
        this.result = result;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
