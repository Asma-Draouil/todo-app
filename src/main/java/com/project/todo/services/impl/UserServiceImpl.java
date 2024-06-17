package com.project.todo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.todo.dto.UserDto;
import com.project.todo.repositories.UserRepository;
import com.project.todo.services.UserService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	
	private final UserRepository userRepository;
	
	@Override
	public UserDto save(UserDto user) {
	
		return UserDto.fromEntity(userRepository.save(UserDto.toEntity(user)));
	}

	@Override
	public List<UserDto> findAll() {
		
		return userRepository.findAll().stream()
				.map(UserDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public UserDto findById(long id) {

		return userRepository.findById(id).map(UserDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("No user is found with ID = " +id));
	}

	@Override
	public void delete(long id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public UserDto login(UserDto user) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
