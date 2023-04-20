package com.codewithvatsal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithvatsal.blog.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
