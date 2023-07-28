package com.example.RecipeManagementAPI.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class,property="userId")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    @NotEmpty
    private String password;
    @Email
    private String email;

    @OneToOne(mappedBy="user")
    private PremiumRole role;


    public User(String userName ,String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }
}
