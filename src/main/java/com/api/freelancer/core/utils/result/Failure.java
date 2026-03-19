package com.api.freelancer.core.utils.result;

public final record Failure<T>(String message)implements Result<T> {
}
