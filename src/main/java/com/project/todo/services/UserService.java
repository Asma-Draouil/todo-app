package com.project.todo.services;

import java.util.List;

import com.project.todo.dto.UserDto;

public interface UserService {
UserDto save(UserDto user);
List<UserDto> findAll();
UserDto findById(long id);
void delete(long id);
UserDto login(UserDto user);
	
	
	
	
	
	
	
	
	
	
}
