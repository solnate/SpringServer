package com.teko.spring.Server.entity;

public class ErrorResponse {
    private String success;
    private Result result;

    public ErrorResponse(String success, String code, String description) {
        this.success = success;
        this.result = new Result(code, description);
    }

    public ErrorResponse() {
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

    private static class Result{
        private String code;
        private String description;

        public Result(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public Result() {
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
