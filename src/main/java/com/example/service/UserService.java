package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by user on 2017-05-12.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User insert(User user){
        return userRepository.save(user);
    }

    public User selectByUserId(String userId){
        return userRepository.findByUserId(userId);
    }
}
