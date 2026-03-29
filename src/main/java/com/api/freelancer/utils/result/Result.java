package com.api.freelancer.utils.result;

public sealed abstract class Result<T> permits Success, Failure {
    protected T data;
    protected String message;
    protected String status;
    protected int code;
    protected Object errors;

    public Result(
            T data,
            String message,
            Object errors,
            String status,
            int code
    ) {
        this.data = data;
        this.errors = errors;
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public int getCode() {
        return code;
    }

    public Object getErrors() {
        return errors;
    }
}
