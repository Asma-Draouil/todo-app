package com.project.todo.controllers.api;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.todo.dto.CategorieDto;
import com.project.todo.dto.TodoDto;
import com.project.todo.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.websocket.server.PathParam;

@Api(Constants.APP_ROOT + "/categories")
public interface CategorieApi {

	
	@PostMapping(value = Constants.APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Create category", notes = "Creates a new category ", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created Category.")
    })
    ResponseEntity<CategorieDto> createCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategorieDto categoryDto);

    @PatchMapping(value =Constants.APP_ROOT + "/categories/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Update Category", notes = "Updates an existing Category ", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The newly created user.")
    })
    ResponseEntity<CategorieDto> updateCategory(
            @ApiParam(value = "Category DTO", required = true) @RequestBody CategorieDto categoryDto);

    @GetMapping(value =Constants. APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns the list of the categories", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the categories"),
    })
    ResponseEntity<List<CategorieDto>> getAllCategories();

    @GetMapping(value = Constants.APP_ROOT + "/categories/todos/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Todo Details by category ID", notes = "Returns the list of the Todo of a selected category", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesId(
            @ApiParam(value = "Category ID", required = true) Long id
    );

    @GetMapping(value = Constants.APP_ROOT + "/categories/todos/today/{userId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "List of all categories and Todo for today", notes = "Returns the list of the Todo of a selected category", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the Todos"),
    })
    ResponseEntity<List<TodoDto>> getAllTodoByCategoriesForToday(
            @ApiParam(value = "User ID", required = true) @PathParam("userId") Long userId
    );

    @GetMapping(value = Constants.APP_ROOT + "/categories/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details by user ID", notes = "Returns the list of the categories of a selected user", responseContainer = "List<CategoryDto>")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of the categories"),
    })
    ResponseEntity<List<CategorieDto>> getAllCategoriesByUserId(
            @ApiParam(value = "User ID", required = true) Long id
    );

    @GetMapping(value = Constants.APP_ROOT + "/categories/{id:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Category Details", notes = "Returns the list of the users", response = CategorieDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The Category"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    ResponseEntity<CategorieDto> getCategory(
            @ApiParam(value = "The category id", required = true) @PathParam(value = "id") Long id
    );

    @DeleteMapping(value = Constants.APP_ROOT + Constants.APP_ROOT + "/categories/delete/{id:.+}")
    @ApiOperation(value = "Delete category", notes = "Deletes a category by ID")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "The category deleted"),
            @ApiResponse(code = 404, message = "Category not found")
    })
    ResponseEntity deleteCategory(
            @ApiParam(value = "The category id", required = true) Long id
    );
	
	
	
	
	
	
}
