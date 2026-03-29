package com.api.freelancer.utils.result;

import com.api.freelancer.utils.ApiResponse;

public final class Success<T> extends Result<T>{

    public Success(T data, String message, int code) {
        super(data, message, null, "Success", code);
    }
}
