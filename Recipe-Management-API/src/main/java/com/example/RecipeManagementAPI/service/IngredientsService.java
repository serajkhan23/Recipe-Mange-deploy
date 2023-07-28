package com.example.RecipeManagementAPI.service;

import com.example.RecipeManagementAPI.model.AuthenticationToken;
import com.example.RecipeManagementAPI.model.Ingredients;
import com.example.RecipeManagementAPI.repository.IIngredientsRepo;
import com.example.RecipeManagementAPI.repository.ITokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    @Autowired
    IIngredientsRepo iRepo;


    @Autowired
    ITokenRepo tokenRepo;
    public void createIngredients(List<Ingredients> ingredients, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.saveAll(ingredients);
        }
    }

    public List<Ingredients> getIngredients(String email, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        return iRepo.findAll();
    }

    public void deleteIngredients(Long id, String token) {
        AuthenticationToken generatedToken = tokenRepo.findFirstByToken(token);
        if(generatedToken.getUser().getRole().getRoleId()==1){
            iRepo.deleteById(id);
        }
    }
}
