package com.project.todo.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.todo.dto.TodoDto;
import com.project.todo.repositories.TodoRepository;
import com.project.todo.services.TodoService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {
	
	private final TodoRepository todoRepository;
	

	@Override
	public TodoDto save(TodoDto todo) {
		
		return TodoDto.fromEntity(todoRepository.save(TodoDto.toEntity(todo)));
	}

	@Override
	public List<TodoDto> findAll() {
		
		return todoRepository.findAll().stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public TodoDto findById(long id) {
		
		return todoRepository.findById(id)
				.map(TodoDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("No Todo is found with ID = " +id));
	}

	@Override
	public void delete(long id) {
	todoRepository.deleteById(id);
		
	}

	@Override
	public List<TodoDto> findByCategorie(long categorieId) {
	
		return todoRepository.findByCategorieId(categorieId).stream()
				.map(TodoDto::fromEntity)
				.collect(Collectors.toList());
	}

}
