package com.api.freelancer.application.user.port;

import com.api.freelancer.utils.result.Result;
import com.api.freelancer.http.user.dto.response.CreateUserResponse;

public interface CreateUserPresenter {
    public void presentSuccess(CreateUserResponse response) throws Exception;
    public void presentFailure(String message);
    public Result<?> getResult();
}
