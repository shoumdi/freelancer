package com.api.freelancer.user.application.mapper;

import com.api.freelancer.auth.http.dto.request.RegisterUserRequest;
import com.api.freelancer.user.infrastructure.entity.User;

public class UserMapper {
    public static User toEntity(RegisterUserRequest req){
        return new User();
    }
}
