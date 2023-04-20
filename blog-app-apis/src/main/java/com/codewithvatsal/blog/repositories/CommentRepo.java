package com.codewithvatsal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithvatsal.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer>{

}
