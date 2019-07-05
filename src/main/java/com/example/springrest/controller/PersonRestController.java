package com.example.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springrest.model.Person;
import com.example.springrest.service.PersonService;

@RestController
@RequestMapping(value = "")
public class PersonRestController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(value = "{id}")
	public Person getPerson(@PathVariable Long id) {
		return personService.getPerson(id);
	}
	
	@GetMapping
	public List<Person> getPersons() {
		return personService.list();
	}
	
	@PostMapping
	public Person savePerson(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@PutMapping(value = "{id}")
	public Person updatePerson(@PathVariable Long id, @RequestBody Person person) {
		if(null != person.getId() && id == person.getId())
			return personService.update(person);
		else if(null == person.getId()) {
			person.setId(id);
			return personService.update(person);
		}else {
			throw new RuntimeException("Invalid Data");
		}
	}
	
	@DeleteMapping(value = "{id}")
	public Boolean deletePerson(@PathVariable Long id) {
		return personService.delete(id);
	}
	
	
	
	

}
