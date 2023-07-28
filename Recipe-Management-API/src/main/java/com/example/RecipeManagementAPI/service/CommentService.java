package com.example.RecipeManagementAPI.service;

import com.example.RecipeManagementAPI.model.Comment;
import com.example.RecipeManagementAPI.repository.ICommentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CommentService {

    @Autowired
    ICommentRepo commentRepo;

    public String addComment(Comment comment) {
        comment.setCommentCreationTimeStamp(LocalDateTime.now());
        commentRepo.save(comment);
        return "Comment has been added!!!";
    }

   


    public void removeComment(Comment comment) {
        commentRepo.delete(comment);
    }
}
