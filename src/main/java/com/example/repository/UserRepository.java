package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by user on 2017-05-11.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
