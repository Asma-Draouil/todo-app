package com.project.todo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.project.todo.model.Categorie;

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
public class CategorieDto {

    private long id;
	
    @NotNull(message = "Please fill the name")
    @NotEmpty(message = "Please fill the name")
	private String name;
	
    @NotNull(message = "Please fill the description")
    @NotEmpty(message = "Please fill the description")
	private String description;
    
    private UserDto user;
    
    private List<TodoDto> todoList;
	
public static Categorie toEntity(CategorieDto categorieDto)	{
	return Categorie.builder()
			.id(categorieDto.getId())
			.name(categorieDto.getName())
			.description(categorieDto.getDescription())
			.user(UserDto.toEntity(categorieDto.getUser()))
			.build();
}

public static CategorieDto fromEntity(Categorie categorie)	{
	return CategorieDto.builder()
			.id(categorie.getId())
			.name(categorie.getName())
			.description(categorie.getDescription())
			.todoList(categorie.getTodoList()!=null ? categorie.getTodoList().stream().map(TodoDto::fromEntity).collect(Collectors.toList()) :null)
			.build();
}

}
