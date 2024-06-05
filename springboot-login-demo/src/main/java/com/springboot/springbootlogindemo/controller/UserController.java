package com.springboot.springbootlogindemo.controller;

import com.springboot.springbootlogindemo.domain.User;
import com.springboot.springbootlogindemo.service.UserService;
import com.springboot.springbootlogindemo.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<User> loginController(@RequestParam String uname, @RequestParam String password){
        User user = userService.loginService(uname, password);
        if(user!=null){
            return Result.success(user,"Login successfully!");
        }else{
            return Result.error("123","Username or password is incorrect!");
        }
    }

    @PostMapping("/register")
    public Result<User> registController(@RequestBody User newUser){
        User user = userService.registService(newUser);
        if(user!=null){
            return Result.success(user,"Registration successful!");
        }else{
            return Result.error("456","Username already exists!");
        }
    }
}
