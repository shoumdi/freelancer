package com.api.freelancer.application.user.port;

import com.api.freelancer.http.user.dto.request.CreateUserRequest;

public interface CreateUserUseCase {
    public void execute(CreateUserRequest request) throws Exception;
}
