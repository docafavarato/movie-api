package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
	List<Movie> findByNameIgnoreCaseContains(String name);
	List<Movie> findByYearReleased(Integer yearReleased);
	List<Movie> findByCategoriesId(Long categoryId);
	List<Movie> findByStreamingsId(Long streamingId);
	List<Movie> findByActorsId(Long actorId);
	List<Movie> findByYearReleasedAndCategoriesId(Integer yearReleased, Long categoryId);
}
