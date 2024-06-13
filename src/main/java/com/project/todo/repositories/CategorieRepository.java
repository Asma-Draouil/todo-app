package com.project.todo.repositories;

import java.time.ZonedDateTime;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.todo.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
List<Categorie> findCategorieByUserId(long userId);


@Query("select c from Categorie c inner join Todo t on t.categorie.id = c.id where t.startDate >= :startDate and t.startDate <= :endDate and c.user.id = :userId")
List<Categorie> getAllTodoByCategoriesForToday(@Param("startDate") ZonedDateTime startDate, @Param("endDate") ZonedDateTime endDate, @Param("userId")Long userId);
}
