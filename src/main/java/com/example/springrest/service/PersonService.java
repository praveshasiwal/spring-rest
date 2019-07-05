package com.example.springrest.service;

import java.util.List;

import com.example.springrest.model.Person;

public interface PersonService {

	public Person getPerson(Long id);

	public List<Person> list();

	public Person save(Person person);

	public Person update(Person person);

	public Boolean delete(Long id);

}
