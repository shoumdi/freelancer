package com.api.freelancer.user.infrastructure.repository;

import com.api.freelancer.user.infrastructure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    public User findByEmail(String email);
}
