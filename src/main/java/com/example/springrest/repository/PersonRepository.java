package com.example.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springrest.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
	
//	TODO Custom Named Query method 

}
