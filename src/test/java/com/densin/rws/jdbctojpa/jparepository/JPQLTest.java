package com.densin.rws.jdbctojpa.jparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.densin.rws.jdbctojpa.JpaApplication;
import com.densin.rws.jdbctojpa.entity.Course;

import net.bytebuddy.asm.Advice.This;

@SpringBootTest(classes = JpaApplication.class)
class JPQLTest {
	private Logger logger = LoggerFactory.getLogger(This.class);
	@Autowired
	EntityManager entityManager;

	@Test
	void JPQL_basic() {
		Query query =entityManager.createQuery("Select c from Course c");
		List resultList =query.getResultList();
		logger.info("Select c from Course c -> {} ", resultList);

	}

	@Test    // this is the latest to use createNamedQuery , which teh same as previous method
	void JPQL_basic_querynamed() {
		Query query =entityManager.createNamedQuery("query_get_all_courses");
		List resultList =query.getResultList();
		logger.info("Select c from Course c -> {} ", resultList);

	}
	
	
 
	@Test
	void JPQL_nottyped() { // alt shift l to extract local variables
		EntityManager query = entityManager;
		List resultList = query.createQuery("Select c from Course c", Course.class).getResultList();
		logger.info("typed Select c from Course c -> {} ", resultList);

	}
	
	// check TypedQuery  
	@Test
	void JPQL_typed1() { // alt shift l to extract local variables
		TypedQuery<Course> query = entityManager.createQuery("Select c from Course c", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("typed1 Select c from Course c -> {} ", resultList);

	}
	
	
	
	@Test
	void JPQL_where() { // alt shift l to extract local variables
		TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where name like '%100 steps' ", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("typed1 Select c from Course c where name like %100 Steps -> {} ", resultList);

	}

	
	// using named query
	//
	@Test
	void JPQL_where_named_query() { // alt shift l to extract local variables
		TypedQuery<Course> query = entityManager.createNamedQuery("query_get_specfic_steps", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("typed1 Select c from Course c where name like %100 steps -> {} ", resultList);

	}
	
}
