package com.api.freelancer.user.application.interactor;

import com.api.freelancer.core.utils.result.Failure;
import com.api.freelancer.core.utils.result.Result;
import com.api.freelancer.core.utils.result.Success;
import com.api.freelancer.user.application.mapper.UserMapper;
import com.api.freelancer.user.application.input.CreateUserUseCase;
import com.api.freelancer.user.application.output.CreateUserPresenter;
import com.api.freelancer.user.http.dto.request.CreateUserRequest;
import com.api.freelancer.user.infrastructure.entity.User;
import com.api.freelancer.user.infrastructure.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class CreateUserInteractor implements CreateUserUseCase {

    private IUserRepository userRepository;
    private CreateUserPresenter presenter;

    @Autowired
    public CreateUserInteractor(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Override
    public Object execute(CreateUserRequest req) {
        if(Objects.nonNull(this.userRepository.findByEmail(req.email())))
            throw new RuntimeException("Email already used");
        User user = this.userRepository.save(UserMapper.toEntity(req));
        return presenter.presentSuccess();
    }
}
