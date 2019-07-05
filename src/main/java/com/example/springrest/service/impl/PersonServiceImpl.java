package com.example.springrest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springrest.model.Person;
import com.example.springrest.repository.PersonRepository;
import com.example.springrest.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired
	PersonRepository personRepository; 

	@Override
	public Person getPerson(Long id) {
		if(null != id)
			return personRepository.getOne(id);
		return null;
	}

	@Override
	public List<Person> list() {
		return personRepository.findAll();
	}

	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person update(Person person) {
		if(null != person.getId())
			return personRepository.save(person);
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		
		if(null != id) {
			Optional<Person> person = personRepository.findById(id);
			
			if(person.isPresent()) {
				personRepository.deleteById(id);
				return true;
			}
		}				
		return false;
	}

}
