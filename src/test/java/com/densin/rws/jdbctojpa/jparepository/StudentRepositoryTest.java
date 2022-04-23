package com.densin.rws.jdbctojpa.jparepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import com.densin.rws.jdbctojpa.JpaApplication;
import com.densin.rws.jdbctojpa.entity.Student;

import net.bytebuddy.asm.Advice.This;

@SpringBootTest(classes = JpaApplication.class)
class StudentRepositoryTest {
	private Logger logger = LoggerFactory.getLogger(This.class);
	@Autowired
	StudentRepository repository;

@Autowired
EntityManager em;
	@Test
	@Transactional
	void retreiveStudentandPasportdetails() {
	Student st = 	em.find(Student.class, 20002L);
	
	logger.info("Student ->{} ",st);
	}
	@Test
	@Transactional
	void sometest() {
	// Database operation 1 - retireive student
		Student student =em.find(Student.class, 20001L) ;
		// Database operation 1 - retireive passpoert
		// Database operation 1 - update passport 
		// Database operation 1 - update student 
	}
	
	@Test
	void findById_basic() {
		Student student = repository.findById(10001L);

		assertEquals("JPA in 50 steps", student.getName());
//		logger.info("test is running ->",student);

	}

	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void deleteById_basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));

//		logger.info("test is running ->",student);

	}
	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void saveByEntity_basic() {
		Student student = new Student("student name 2");
		repository.save(student);
		
	//	assertNull(repository.findById(10002L));
		assertEquals("student name 2", student.getName());
//		logger.info("test is running ->",student);

	}
	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void UpdateByEntity_basic() {
		
		Student student = repository.findById(10002L);
		assertEquals("Spring in 150 steps", student.getName());
		
		student.setName("Spring in 50 steps");
		repository.save(student);
		
		Student student1 = repository.findById(10002L);
		assertEquals("Spring in 50 steps", student1.getName());


	}
	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void playWithEnityManager() {
		
		repository.playWithEntityManager();
	

	}
	
	@Test
	 @DirtiesContext   // in order to return back data as it were 
	void playWithname_setnull() {
		
		repository.playWithname_setnull();
	

	}
	
}
