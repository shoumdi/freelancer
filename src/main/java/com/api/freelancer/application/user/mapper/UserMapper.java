package com.api.freelancer.application.user.mapper;

import com.api.freelancer.core.user.Password;
import com.api.freelancer.core.user.Role;
import com.api.freelancer.core.user.User;
import com.api.freelancer.http.user.dto.request.CreateUserRequest;
import com.api.freelancer.http.user.dto.response.CreateUserResponse;
import com.api.freelancer.infrastructure.user.persistance.entity.RoleEntity;
import com.api.freelancer.infrastructure.user.persistance.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = UserVOMapper.class)
public interface UserMapper {

    @Mapping(target = "password", source = "password")
    public UserEntity toEntity(User user);

    public User toModel(UserEntity entity);

    public User toModel(CreateUserRequest req);

    //    @Mapping(target = "role", ignore = true)
    public CreateUserResponse toPresentation(User user);

}
