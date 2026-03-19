package com.api.freelancer.user.mapper;

import com.api.freelancer.auth.request.RegisterUserRequest;
import com.api.freelancer.user.entity.User;

public class UserMapper {
    public static User toEntity(RegisterUserRequest req){
        return new User();
    }
}
