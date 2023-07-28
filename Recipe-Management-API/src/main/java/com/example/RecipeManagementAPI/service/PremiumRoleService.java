package com.example.RecipeManagementAPI.service;

import com.example.RecipeManagementAPI.model.PremiumRole;
import com.example.RecipeManagementAPI.repository.IPremiumRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumRoleService {
    @Autowired
    IPremiumRoleRepo roleRepo;

    @Autowired
    AdminService adminService;

    public String createRole(PremiumRole role , String email){
        if(adminService.isValidEmail(email)){
            roleRepo.save(role);
            return "Premium role created successfully....";
        }else
            return "You don't have the access to create premium roles..";
    }
}
