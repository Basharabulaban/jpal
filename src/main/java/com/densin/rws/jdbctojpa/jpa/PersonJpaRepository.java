package com.densin.rws.jdbctojpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

//import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Person;

//Repository
//transaction
@Repository
public class PersonJpaRepository  {
// connect to database
	@PersistenceContext
	EntityManager  entityManager;
	
	
	public Person findbyId(int id){
		return  entityManager.find(Person.class,id)  ; /// null	;// jpa
}
}

