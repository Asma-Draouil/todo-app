package com.project.todo.controllers.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.todo.dto.TodoDto;
import com.project.todo.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.websocket.server.PathParam;



@Api(Constants.APP_ROOT + "/todos")
public interface TodoApi {
	 @PostMapping(value = Constants.APP_ROOT + "/todos/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Create To do", notes = "Creates a new to do ", response = TodoDto.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 201, message = "The newly created To do.")
	    })
	    ResponseEntity<TodoDto> createTodo(
	            @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto todoDto);

	    @PatchMapping(value = Constants.APP_ROOT + "/todos/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Update Todo", notes = "Updates an existing Todo ", response = TodoDto.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 201, message = "The newly created Todo.")
	    })
	    ResponseEntity<TodoDto> updateTodo(
	            @ApiParam(value = "Todo DTO", required = true) @RequestBody TodoDto user);

	    @GetMapping(value = Constants.APP_ROOT + "/todos/all", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Todo Details", notes = "Returns the list of the Todos", responseContainer = "List<TodoDto>")
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "List of the Todos"),
	    })
	    ResponseEntity<List<TodoDto>> getAllTodos();

	    @GetMapping(value = Constants.APP_ROOT + "/todos/{todoId:.+}", produces = MediaType.APPLICATION_JSON_VALUE)
	    @ApiOperation(value = "Todo Details", notes = "Returns the Todo", response = TodoDto.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "The Todo"),
	            @ApiResponse(code = 404, message = "Todo not found")
	    })
	    ResponseEntity<TodoDto> getTodo(
	            @ApiParam(value = "The Todo id", required = true) @PathParam(value = "todoId") Long todoId
	    );

	    @DeleteMapping(value = Constants.APP_ROOT + "/todos/delete/{id:.+}")
	    @ApiOperation(value = "Delete Todo", notes = "Deletes a Todo by ID", response = TodoDto.class)
	    @ApiResponses(value = {
	            @ApiResponse(code = 200, message = "The Todo deleted"),
	            @ApiResponse(code = 404, message = "Todo not found")
	    })
	    ResponseEntity deleteTodo(
	            @ApiParam(value = "The Todo id", required = true) Long id
	    );
}
