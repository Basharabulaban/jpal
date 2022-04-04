package com.densin.rws.jdbctojpa.jparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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
class CourseRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(This.class);
	@Autowired
	CourseRepository repository;

	@Test
	void findById_basic() {
		Course course = repository.findById(10001L);

		assertEquals("JPA in 50 steps", course.getName());
//		logger.info("test is running ->",course);

	}

	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));

//		logger.info("test is running ->",course);

	}
}
