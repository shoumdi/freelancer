package com.api.freelancer.core.utils.result;

public sealed interface Result<T> permits Success,Failure{
}
