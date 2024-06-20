package com.project.todo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.todo.controllers.api.UserApi;
import com.project.todo.dto.UserDto;
import com.project.todo.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class UserController implements UserApi {
	
	private final UserService userService;
	
	@Override
	public ResponseEntity<UserDto> createUser(UserDto user) {

		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<UserDto> updateUser(Long id, UserDto user) {
		
		return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<UserDto>> getAllUsers() {
	
		return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<UserDto> getUser(Long id) {
		
		return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteUser(Long id) {
		userService.delete(id);
		return new ResponseEntity(HttpStatus.OK);
	}

}
