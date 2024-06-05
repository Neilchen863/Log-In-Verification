package com.springboot.springbootlogindemo.service;

import com.springboot.springbootlogindemo.domain.User;

public interface UserService {
    /**
     * Login business logic
     * @param uname Username
     * @param password Password
     * @return User object if login is successful, null otherwise
     */
    User loginService(String uname, String password);

    /**
     * Registration business logic
     * @param user The User object to be registered. The primary key uid should be null.
     * If uid is not null, it might overwrite an existing user.
     * @return The newly registered User object, null if registration fails
     */
    User registService(User user);
}
