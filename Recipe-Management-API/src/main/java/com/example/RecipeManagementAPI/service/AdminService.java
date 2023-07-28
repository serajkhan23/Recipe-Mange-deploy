package com.example.RecipeManagementAPI.service;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    public boolean isValidEmail(String email){
        if(email!=null){
            Pattern p = Pattern.compile("^.*@headadmin\\.com$");
            Matcher m = p.matcher(email);
            if((m.find() && m.group().equals(email)))
                return true;
            else
                return false;
        }
        return false;
    }
}
