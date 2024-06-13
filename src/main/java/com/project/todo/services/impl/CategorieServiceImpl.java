package com.project.todo.services.impl;

import java.time.ZonedDateTime;
import java.util.List;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.project.todo.dto.CategorieDto;
import com.project.todo.repositories.CategorieRepository;
import com.project.todo.services.CategorieService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategorieServiceImpl implements CategorieService{
	
	private final CategorieRepository categorieRepository;

	@Override
	public CategorieDto save(CategorieDto category) {
	
		return CategorieDto.fromEntity(categorieRepository.save(CategorieDto.toEntity(category)));
	}

	@Override
	public List<CategorieDto> findAll() {
	
		return categorieRepository.findAll()
				.stream()
				.map(CategorieDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public CategorieDto findById(long id) {

		return (categorieRepository.findById(id)).map(CategorieDto::fromEntity)
				.orElseThrow(()-> new EntityNotFoundException("No category with th Id " + id));
	}

	@Override
	public void delete(long id) {
		categorieRepository.deleteById(id);
		
	}

	@Override
	public List<CategorieDto> findAllByUserId(long userId) {
		
		return categorieRepository.findCategorieByUserId(userId)
				.stream()
				.map(CategorieDto::fromEntity)
				.collect(Collectors.toList());
	}

	@Override
	public List<CategorieDto> getAllTodoByCategoriesForToday(long userId) {
		
		return categorieRepository.getAllTodoByCategoriesForToday(ZonedDateTime.now().withHour(0).withMinute(0), ZonedDateTime.now().withHour(23).withMinute(59), userId)
				.stream()
				.map(CategorieDto::fromEntity)
				.collect(Collectors.toList());
	}

	
	
}
