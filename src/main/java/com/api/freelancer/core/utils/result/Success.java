package com.api.freelancer.core.utils.result;

public final record Success<T>(T data) implements Result<T> {
}
