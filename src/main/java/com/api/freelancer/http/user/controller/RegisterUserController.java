package com.api.freelancer.http.user.controller;

import com.api.freelancer.infrastructure.jwt.Authenticable;
import com.api.freelancer.utils.result.Failure;
import com.api.freelancer.utils.result.Success;
import com.api.freelancer.application.user.port.CreateUserUseCase;
import com.api.freelancer.application.user.port.CreateUserPresenter;
import com.api.freelancer.http.user.dto.request.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.InvalidRoleValueException;

@RestController
@RequestMapping(value = "/api/v1/auth")
public class RegisterUserController {

    private final CreateUserUseCase createUserUseCase;
    private final CreateUserPresenter presenter;

    @Autowired
    public RegisterUserController(
            CreateUserUseCase createUserUseCase,
            CreateUserPresenter presenter) {
        this.createUserUseCase=createUserUseCase;
        this.presenter=presenter;

    }

    @PostMapping(value = "/register")
    public ResponseEntity<?> store(@Validated @RequestBody CreateUserRequest request) throws InvalidRoleValueException,Exception {
        this.createUserUseCase.execute(request);
        switch (this.presenter.getResult()){
            case Failure<?> f -> {
                return ResponseEntity
                        .status(f.getCode())
                        .body(f);
            }
            case Success<?> s -> {
                return ResponseEntity
                        .status(s.getCode())
                        .body(s);
            }
        }
    }

    @GetMapping(value = "/test")
    public ResponseEntity<?> test(@AuthenticationPrincipal Authenticable details){
        return ResponseEntity.ok(details.getUsername());
    }
}
