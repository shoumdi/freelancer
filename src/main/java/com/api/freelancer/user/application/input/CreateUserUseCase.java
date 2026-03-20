package com.api.freelancer.user.application.input;

import com.api.freelancer.user.http.dto.request.CreateUserRequest;

public interface CreateUserUseCase {
    public Object execute(CreateUserRequest request);
}
