package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Movie;
import com.example.demo.repositories.MovieRepository;

@Service
public class MovieService {

	@Autowired
	public MovieRepository repository;
	
	public List<Movie> findAll() {
		return repository.findAll();
	}
	
	public Movie findById(Long id) {
		Optional<Movie> obj = repository.findById(id);
		return obj.get();
	}
	
	public Movie insert(Movie obj) {
		return repository.save(obj);
	}
	
	public List<Movie> findByNameIgnoreCaseContains(String name) {
		return repository.findByNameIgnoreCaseContains(name);
	}
	
	public List<Movie> findByYearReleased(Integer yearReleased) {
		return repository.findByYearReleased(yearReleased);
	}
	
	public List<Movie> findByCategoriesId(Long categoryId) {
		return repository.findByCategoriesId(categoryId);
	}
	
	public List<Movie> findByStreamingId(Long streamingId) {
		return repository.findByStreamingsId(streamingId);
	}
	
	public List<Movie> findByYearReleasedAndCategoriesId(Integer yearReleased, Long categoryId) {
		return repository.findByYearReleasedAndCategoriesId(yearReleased, categoryId);
	}
	
	public List<Movie> findByActorsId(Long actorId) {
		return repository.findByActorsId(actorId);
	}
}
