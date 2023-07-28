package com.example.RecipeManagementAPI.service;

import com.example.RecipeManagementAPI.dto.SignInInput;
import com.example.RecipeManagementAPI.dto.SignInOutput;
import com.example.RecipeManagementAPI.dto.SignUpInput;
import com.example.RecipeManagementAPI.dto.SignUpOutput;
import com.example.RecipeManagementAPI.model.AuthenticationToken;
import com.example.RecipeManagementAPI.model.User;
import com.example.RecipeManagementAPI.repository.IUserRepo;
import jakarta.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {
    @Autowired
    IUserRepo userRepo;

    @Autowired
    PremiumRoleService roleService;

    @Autowired
    TokenService tokenService;

    public SignUpOutput signUp(SignUpInput signUpDto) {
        User user = userRepo.findFirstByEmail(signUpDto.getEmail());
        if(user!=null){
            throw new IllegalStateException("User already registered with your email address.... Please log in");
        }
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signUpDto.getPassword());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        user = new User(signUpDto.getUserName(),encryptedPassword,signUpDto.getEmail());
        userRepo.save(user);
        return new SignUpOutput("Recipe Management User registered","Account has been created successfully");
    }

    private String encryptPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(password.getBytes());
        byte[] digested = md5.digest();
        String hash = DatatypeConverter.printHexBinary(digested);
        return hash;
    }

    public SignInOutput signIn(SignInInput signInDto) {
        User user = userRepo.findFirstByEmail(signInDto.getEmail());
        if(user==null)
            throw new IllegalStateException("User details not found...Please register yourself first");
        String encryptedPassword = null;
        try{
            encryptedPassword = encryptPassword(signInDto.getPassword());
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }

        boolean isPasswordValid = encryptedPassword.equals(user.getPassword());
        if(!isPasswordValid){
            throw new IllegalStateException("User details not found...Please register yourself first");
        }
        AuthenticationToken token = new AuthenticationToken(user);
        tokenService.saveToken(token);
        return new SignInOutput("Authentication done successfully...",token.getToken());

    }

    public List<User> getUsers() {
        return userRepo.findAll();
    }
}
