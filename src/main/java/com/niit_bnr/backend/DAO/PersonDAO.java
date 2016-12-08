package com.niit_bnr.backend.DAO;

import java.util.List;

import com.niit_bnr.backend.model.Person;

public interface PersonDAO {

	void addPerson(Person p);
	void updatePerson(Person p);
	List<Person> getAllPerson();
	Person getPersonById(int id);
}
