package com.api.freelancer.auth.http.controller;

import com.api.freelancer.auth.http.dto.request.RegisterUserRequest;
import com.api.freelancer.core.utils.result.Failure;
import com.api.freelancer.core.utils.result.Result;
import com.api.freelancer.core.utils.result.Success;
import com.api.freelancer.user.infrastructure.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1")
public class RegisterUserController {

    private RegisterUserService registerService;

    @Autowired
    public RegisterUserController(RegisterUserService service) {
        this.registerService=service;
    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> store(@RequestBody RegisterUserRequest request){
        Result<User> result = this.registerService.register(request);
        switch (result){
            case Failure<User> f -> {
                return ResponseEntity
                        .status(HttpStatus.IM_USED)
                        .body(f.message());
            }
            case Success<User> s -> {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body(s.data());
            }
        }
    }
}
