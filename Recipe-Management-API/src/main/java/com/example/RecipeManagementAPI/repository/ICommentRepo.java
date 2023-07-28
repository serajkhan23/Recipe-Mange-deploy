package com.example.RecipeManagementAPI.repository;

import com.example.RecipeManagementAPI.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICommentRepo extends JpaRepository<Comment,Integer> {
}
