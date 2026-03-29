package com.api.freelancer.http.user.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateUserRequest(
        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 30,message = "User name should have more than 2 and less than 31 chars")
        String username,
        @Email(message = "Email should be valid")
        @NotBlank(message = "Email is required")
        @Size(max = 50,message = "Email shouldn't exceed 50")
        String email,
        @NotBlank(message = "Password is required")
//        @Pattern(regexp = "[A-Za-z]+",message = "Password should at least contain one Uppercase")
        @Size(min=8,message = "Password should at least contain 8 chars")
        String password
) {
}
