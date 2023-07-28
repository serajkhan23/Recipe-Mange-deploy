package com.example.RecipeManagementAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    private String name;
    private Integer servings;
    @Enumerated(EnumType.STRING)
    private ProcessStatus process;
    private  String instructions;
    @ManyToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
    @OneToMany
    @JoinColumn(name= "fk_ingredients_id")
    private List<Ingredients> ingredients;
}
