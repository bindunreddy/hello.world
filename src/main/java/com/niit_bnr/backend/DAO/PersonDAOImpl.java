package com.niit_bnr.backend.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit_bnr.backend.model.Person;

@Repository
@Transactional
@EnableTransactionManagement
public class PersonDAOImpl implements PersonDAO {
	
	
	@Autowired
	SessionFactory sessionFactory;

	public void addPerson(Person p) {
		
		 	
		
	}

	public void updatePerson(Person p) {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAllPerson() {
		
		Session session=sessionFactory.getCurrentSession();
		
		List<Person > person=session.createQuery("From Person").getResultList();
		return person;
		
		
	}

	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
