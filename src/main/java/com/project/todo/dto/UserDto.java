package com.project.todo.dto;


import com.project.todo.model.User;

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
public class UserDto {

	private long id;
	
	@NotNull(message = "Please fill the First name")
	@NotEmpty(message = "Please fill the First name")
	private String firstname;
	
	@NotNull(message = "Please fill the Last name")
	@NotEmpty(message = "Please fill the Last name")
	private String lastname;
	
	@NotNull(message = "Please fill the email")
	@NotEmpty(message = "Please fill the email")
	private String email;
	
	@NotNull(message = "Please fill the User name")
	@NotEmpty(message = "Please fill the User name")
	private String username;
	
	@NotNull(message = "Please fill the password")
	@NotEmpty(message = "Please fill the password")
	private String password;	
	
	
public static User toEntity	(UserDto userDto) {
	return User.builder()
			.id(userDto.getId())
			.firstname(userDto.getFirstname())
			.lastname(userDto.getLastname())
			.email(userDto.getEmail())
			.username(userDto.getUsername())
			.password(userDto.getPassword())
			.build();
}
	
public static UserDto fromEntity(User user)	{
	return UserDto.builder()
			.id(user.getId())
			.firstname(user.getFirstname())
			.lastname(user.getLastname())
			.email(user.getEmail())
			.username(user.getUsername())
			.password(user.getPassword())
			.build();
}
	
	
	
}
