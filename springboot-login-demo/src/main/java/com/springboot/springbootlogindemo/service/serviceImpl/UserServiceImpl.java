package com.springboot.springbootlogindemo.service.serviceImpl;

import com.springboot.springbootlogindemo.domain.User;
import com.springboot.springbootlogindemo.repoitory.UserDao;
import com.springboot.springbootlogindemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String uname, String password) {
        // If both username and password are correct, return the logged-in user object; if either is incorrect, return null
        User user = userDao.findByUnameAndPassword(uname, password);
        // Clear important information
        if (user != null) {
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        // When the username of the new user already exists
        if (userDao.findByUname(user.getUname()) != null) {
            // Unable to register
            return null;
        } else {
            // Return the newly created user object (with uid)
            User newUser = userDao.save(user);
            if (newUser != null) {
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}
