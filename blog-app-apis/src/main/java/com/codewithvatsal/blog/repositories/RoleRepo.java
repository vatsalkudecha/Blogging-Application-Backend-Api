package com.codewithvatsal.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithvatsal.blog.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
