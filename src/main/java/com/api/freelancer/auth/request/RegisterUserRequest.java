package com.api.freelancer.auth.request;

import jakarta.persistence.Column;

public record RegisterUserRequest(
        String username,
        String email,
        String password
) {
}
