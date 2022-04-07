package com.densin.rws.jdbctojpa.jparepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Course;

import net.bytebuddy.asm.Advice.This;
@Repository
@Transactional

public class CourseRepository {
@Autowired
EntityManager entityManager ;
private Logger logger = LoggerFactory.getLogger(This.class);

public Course findById(Long id) {
	return entityManager.find(Course.class, id);
	
}

public Course save(Course course) {
	if (course.getId()==null) {
		entityManager.persist(course);
	}else {
		entityManager.merge(course);
	}
	return course;
}



public void deleteById(long id) {
	Course course = findById(id);
	
	 entityManager.remove(course) ;
	
}

public void playWithEntityManager() {
	logger.info("playWithEntityManager - start");
	// entityManager.persist(new Course("Web Services in 10 steps"));  // Alt shift l
	
	Course course = new Course("Web Services in 10 steps");
	entityManager.persist(course);
	
	entityManager.flush();  // changes will be send out to databases
	
	course.setName("Web Services in 10 steps-update");
	entityManager.flush();  // changes will be send out to databases
	
	Course course2 = new Course("React js in 120 steps");
	entityManager.persist(course2);
	entityManager.flush();  // changes will be send out to databases
	
	entityManager.detach(course2);
	
	course2.setName("React js in 120 steps-update");
	entityManager.flush();  // chnages will be send out to databases
		
}

}
