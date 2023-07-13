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

import com.example.demo.entities.Actor;
import com.example.demo.services.ActorService;

@RestController
@RequestMapping(value="/actors")
public class ActorResource {
	
	@Autowired
	private ActorService service;
	
	@GetMapping
	public ResponseEntity<List<Actor>> findAll() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Actor> findById(@PathVariable Long id) {
		return ResponseEntity.ok().body(service.findById(id));
	}
	
	@GetMapping(value="/search", params={"name"})
	public ResponseEntity<List<Actor>> findByNameContains(@RequestParam("name") String name) {
		return ResponseEntity.ok().body(service.findByNameContains(name));
	}
	
	@GetMapping(value="/search", params={"age"})
	public ResponseEntity<List<Actor>> findByAge(@RequestParam("age") Integer age) {
		return ResponseEntity.ok().body(service.findByAge(age));
	}
	
	@PostMapping
	public ResponseEntity<Actor> insert(@RequestBody Actor obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}
