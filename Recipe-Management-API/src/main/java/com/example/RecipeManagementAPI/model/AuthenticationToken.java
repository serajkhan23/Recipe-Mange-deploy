package com.example.RecipeManagementAPI.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long tokenId;
    private String token;
    private LocalDate tokenCreationDate;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;

    public AuthenticationToken(User user) {
        this.user = user;
        this.tokenCreationDate = LocalDate.now();
        this.token = UUID.randomUUID().toString();
    }
}
