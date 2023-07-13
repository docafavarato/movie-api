package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Streaming;
import com.example.demo.services.StreamingService;

@RestController
@RequestMapping(value="/streamings")
public class StreamingResource {
	
	@Autowired
	private StreamingService service;
	
	@GetMapping
	public ResponseEntity<List<Streaming>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Streaming> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
}
