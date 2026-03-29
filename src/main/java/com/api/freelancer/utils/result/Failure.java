package com.api.freelancer.utils.result;

public final class Failure<T> extends Result<T> {
    public Failure( String message, Object errors, int code) {
        super(null, message, errors, "Failure", code);
    }

}
