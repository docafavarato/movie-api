package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Streaming;
import com.example.demo.repositories.StreamingRepository;

@Service
public class StreamingService {
	
	@Autowired
	private StreamingRepository repository;
	
	public List<Streaming> findAll() {
		return repository.findAll();
	}
	
	public Streaming findById(Long id) {
		Optional<Streaming> obj = repository.findById(id);
		return obj.get();
	}
}
