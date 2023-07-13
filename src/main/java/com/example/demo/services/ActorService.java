package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Actor;
import com.example.demo.repositories.ActorRepository;

@Service
public class ActorService {
	@Autowired
	private ActorRepository repository;
	
	public List<Actor> findAll() {
		return repository.findAll();
	}
	
	public Actor findById(Long id) {
		Optional<Actor> obj = repository.findById(id);
		return obj.get();
	}
	
	public Actor insert(Actor obj) {
		return repository.save(obj);
	}
	
	public List<Actor> findByNameContains(String name) {
		return repository.findByNameIgnoreCaseContains(name);
	}
	
	public List<Actor> findByAge(Integer age) {
		return repository.findByAge(age);
	}
}
