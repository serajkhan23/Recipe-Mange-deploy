package com.example.RecipeManagementAPI.repository;

import com.example.RecipeManagementAPI.model.PremiumRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPremiumRoleRepo extends JpaRepository<PremiumRole,Long> {
}

