package com.api.freelancer.auth.service;

import com.api.freelancer.auth.request.RegisterUserRequest;
import com.api.freelancer.core.utils.result.Failure;
import com.api.freelancer.core.utils.result.Result;
import com.api.freelancer.core.utils.result.Success;
import com.api.freelancer.user.mapper.UserMapper;
import com.api.freelancer.user.entity.User;
import com.api.freelancer.user.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class RegisterUserService {
    private IUserRepository userRepository;

    @Autowired
    public RegisterUserService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    public Result<User> register(RegisterUserRequest req){
        try{
            if(Objects.nonNull(this.userRepository.findByEmail(req.email())))
                throw new RuntimeException("Email already used");
            User user = this.userRepository.save(UserMapper.toEntity(req));
            return new Success<>(user);
        } catch (RuntimeException e) {
//            throw new RuntimeException(e);
            return new Failure<>(e.getMessage());
        }
    }
}
