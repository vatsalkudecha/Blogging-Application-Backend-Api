package com.codewithvatsal.blog.services;

import java.util.List;

import com.codewithvatsal.blog.payloads.UserDto;

public interface UserService {
	
	// ek method banavisu, j user create krse
	// direct user entity use nai kariye,
	// ena mate alag dto(data transfer object use karsu)
	
	UserDto registerNewUser(UserDto user);
	
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getUsers();
	void deleteUser(Integer userId);
}
