package com.example.RecipeManagementAPI.controller;

import com.example.RecipeManagementAPI.dto.SignInInput;
import com.example.RecipeManagementAPI.dto.SignInOutput;
import com.example.RecipeManagementAPI.dto.SignUpInput;
import com.example.RecipeManagementAPI.dto.SignUpOutput;
import com.example.RecipeManagementAPI.model.User;
import com.example.RecipeManagementAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signUp")
    public SignUpOutput signUp(@RequestBody SignUpInput signUpDto){
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signIn")
    public SignInOutput signIn(@RequestBody SignInInput signInDto){
        return userService.signIn(signInDto);
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }
}
