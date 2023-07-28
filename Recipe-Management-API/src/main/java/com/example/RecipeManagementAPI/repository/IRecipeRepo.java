package com.example.RecipeManagementAPI.repository;

import com.example.RecipeManagementAPI.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IRecipeRepo extends JpaRepository<Recipe, Long> {
}


