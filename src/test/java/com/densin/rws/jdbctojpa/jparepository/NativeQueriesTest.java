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
class NativeQueriesTest {
	private Logger logger = LoggerFactory.getLogger(This.class);
	@Autowired
	EntityManager entityManager;



	
	
	@Test    // this is the latest to use createNamedQuery , which teh same as previous method
	void native_queries_basic() {
		Query query =entityManager.createNativeQuery("Select * from COURSE",Course.class);  /////  we put Course.class to map entity as it appear as Ljava.lang.Object;@2ec5cc14
		List resultList =query.getResultList();
		logger.info(" Native Select * from Course  -> {} ", resultList);

	}
	
	
	@Test
	void Native_Queries_Advance_using_where() { // alt shift l to extract local variables
		Query query = entityManager.createNativeQuery("Select * from COURSE where name like '%100 steps'", Course.class);
		List<Course> resultList = query.getResultList();
		logger.info("NativeQuery Select * from COURSE where name like %100 steps -> {} ", resultList);

	}
	
}
