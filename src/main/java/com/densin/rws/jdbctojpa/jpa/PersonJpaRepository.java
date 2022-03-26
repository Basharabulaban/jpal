package com.densin.rws.jdbctojpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Person;

//Repository
//transaction
@Repository
@Transactional
public class PersonJpaRepository {
// connect to database
	@PersistenceContext
	
	EntityManager entityManager;
	public Person update(Person person) {
		return entityManager.merge(person);
	}
	public Person findbyId(int id) {
		return entityManager.find(Person.class, id);
	}

	

}
