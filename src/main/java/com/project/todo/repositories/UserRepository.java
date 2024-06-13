package com.project.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.todo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
