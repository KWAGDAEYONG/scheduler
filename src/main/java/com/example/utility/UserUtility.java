package com.example.utility;

import com.example.model.User;

/**
 * Created by user on 2017-05-12.
 */
public class UserUtility {
    public static boolean matchPassword(User user, String password) {
        if (user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

