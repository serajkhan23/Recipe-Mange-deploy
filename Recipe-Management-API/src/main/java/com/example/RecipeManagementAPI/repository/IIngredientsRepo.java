package com.example.RecipeManagementAPI.repository;

import com.example.RecipeManagementAPI.model.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IIngredientsRepo extends JpaRepository<Ingredients,Long> {
}

