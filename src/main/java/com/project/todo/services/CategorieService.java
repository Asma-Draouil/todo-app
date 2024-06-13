package com.project.todo.services;

import java.util.List;

import com.project.todo.dto.CategorieDto;

public interface CategorieService {
CategorieDto save(CategorieDto category);
List<CategorieDto> findAll();
CategorieDto findById(long id);
void delete(long id);
List<CategorieDto> findAllByUserId(long userId);
List<CategorieDto> getAllTodoByCategoriesForToday(long userId);
}
