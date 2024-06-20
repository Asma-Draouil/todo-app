package com.project.todo.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.project.todo.controllers.api.CategorieApi;
import com.project.todo.dto.CategorieDto;
import com.project.todo.dto.TodoDto;
import com.project.todo.services.CategorieService;
import com.project.todo.services.TodoService;

import lombok.RequiredArgsConstructor;
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class CategorieControllers implements CategorieApi {
	
	private final CategorieService categorieService;
	private final TodoService todoService;

	@Override
	public ResponseEntity<CategorieDto> createCategory(CategorieDto categoryDto) {
		return new ResponseEntity<>(categorieService.save(categoryDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<CategorieDto> updateCategory(CategorieDto categoryDto) {
		
		return new ResponseEntity<>(categorieService.save(categoryDto), HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<List<CategorieDto>> getAllCategories() {
	
		return new ResponseEntity<>(categorieService.findAll(), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(Long id) {

		return new ResponseEntity<>(todoService.findByCategorie(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(Long userId) {
	
		return new ResponseEntity(categorieService.getAllTodoByCategoriesForToday(userId), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<List<CategorieDto>> getAllCategoriesByUserId(Long id) {

		return new ResponseEntity<>(categorieService.findAllByUserId(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<CategorieDto> getCategory(Long id) {

		return new ResponseEntity<>(categorieService.findById(id), HttpStatus.OK);
	}

	@Override
	public ResponseEntity deleteCategory(Long id) {
		   categorieService.delete(id);
	        return new ResponseEntity(HttpStatus.OK);
	}

}
