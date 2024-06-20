package com.project.todo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.todo.controllers.api.TodoApi;
import com.project.todo.dto.TodoDto;
import com.project.todo.services.CategorieService;
import com.project.todo.services.TodoService;

import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class TodoController implements TodoApi{
	
	private final TodoService todoService;
	

	@Override
	public ResponseEntity<TodoDto> createTodo(TodoDto todoDto) {
	
		return new ResponseEntity<>(todoService.save(todoDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<TodoDto> updateTodo(TodoDto user) {
		
		return new ResponseEntity<>(todoService.save(user), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodos() {
		
		return new ResponseEntity<>(todoService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<TodoDto> getTodo(Long todoId) {
		
		return new ResponseEntity<>(todoService.findById(todoId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteTodo(Long id) {
		
		return null;
	}

}
