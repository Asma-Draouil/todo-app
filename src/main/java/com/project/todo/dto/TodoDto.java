package com.project.todo.dto;

import java.time.ZonedDateTime;

import com.project.todo.model.Todo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TodoDto {
	private long id;
	
	@NotNull(message = "Please fill the title")
	@NotEmpty(message = "Please fill the title")
	private String title;
	
	@NotNull(message = "Please fill the description")
	@NotEmpty(message = "Please fill the description")
	private String description;
	
	private ZonedDateTime startDate;
	
	private boolean done;
	
	private boolean favorite;
	
	private CategorieDto categorie;
	
	
	public static Todo toEntity(TodoDto todoDto) { //request
		return Todo.builder()
				.id(todoDto.getId())
				.title(todoDto.getTitle())
				.description(todoDto.getDescription())
				.done(todoDto.isDone())
				.favorite(todoDto.isFavorite())
				.startDate(todoDto.getStartDate())
				.categorie(CategorieDto.toEntity(todoDto.getCategorie()))
				.build();
	}
	
	public static TodoDto fromEntity(Todo todo) { //response
		return TodoDto.builder()
				.id(todo.getId())
				.title(todo.getTitle())
				.description(todo.getDescription())
				.done(todo.isDone())
				.favorite(todo.isFavorite())
				.startDate(todo.getStartDate())
				.build();
	}
	
	
	
	
	
	
	
}
