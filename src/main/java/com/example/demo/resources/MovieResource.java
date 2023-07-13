package com.example.demo.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.entities.Movie;
import com.example.demo.services.MovieService;

@RestController
@RequestMapping(value="/movies")
public class MovieResource {
	
	@Autowired
	private MovieService service;
	
	@GetMapping
	public ResponseEntity<List<Movie>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Movie> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value="/search", params={"name"})
	public ResponseEntity<List<Movie>> findByNameIgnoreCaseContains(@RequestParam("name") String name) {
		List<Movie> obj = service.findByNameIgnoreCaseContains(name);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/search", params={"year"})
	public ResponseEntity<List<Movie>> findByYearReleased(@RequestParam("year") Integer yearReleased) {
		List<Movie> obj = service.findByYearReleased(yearReleased);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/search", params={"category"})
	public ResponseEntity<List<Movie>> findByCategoriesId(@RequestParam("category") Long categoryId) {
		List<Movie> obj = service.findByCategoriesId(categoryId);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/search", params={"year", "category"})
	public ResponseEntity<List<Movie>> findByYearReleasedAndStreamingId(@RequestParam("year") Integer yearReleased, @RequestParam("category") Long categoryId) {
		List<Movie> obj = service.findByYearReleasedAndCategoriesId(yearReleased, categoryId);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/search", params={"streaming"})
	public ResponseEntity<List<Movie>> findByStreamingId(@RequestParam("streaming") Long streamingId) {
		List<Movie> obj = service.findByStreamingId(streamingId);
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping(value="/search", params={"actor"})
	public ResponseEntity<List<Movie>> findByActorsId(@RequestParam("actor") Long actorId) {
		List<Movie> obj = service.findByActorsId(actorId);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Movie> insert(@RequestBody Movie obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
