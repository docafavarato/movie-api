package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Long> {
	List<Actor> findByNameIgnoreCaseContains(String name);
	List<Actor> findByAge(Integer age);
}
