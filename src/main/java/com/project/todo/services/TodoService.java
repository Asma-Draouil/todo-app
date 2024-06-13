package com.project.todo.services;

import java.util.List;

import com.project.todo.dto.TodoDto;

public interface TodoService {
TodoDto save(TodoDto todo);
List<TodoDto> findAll();
TodoDto findById(long id);
void delete(long id);
List<TodoDto> findByCategorie(long categorieId);
}
