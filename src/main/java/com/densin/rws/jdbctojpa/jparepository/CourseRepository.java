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
	
	Course course1 = new Course("Web Services in 10 steps");
	entityManager.persist(course1);
	Course course2 = new Course("React js in 120 steps");
	entityManager.persist(course2); // save or create entity in database
	//    entityManager.merge(course2); // to save the changes that have done to course2 in database
     //  entityManager.remove(course2);  //to delete an entity
//	entityManager.clear();  // per it location afect what to send to database
	entityManager.flush();  // to pass all changes untill now down to databases
//  entityManager.detach(course2);  // this to not send the update to database for course2 
//  entityManager.clear();
	
	
	course2.setName("React js in 120 steps-update");
	entityManager.refresh(course1);  // this to not update the course record to database and refresh the content by original value
	entityManager.flush();  // changes will be send out to databases 
		
}

public void playWithname_setnull() {
	// TODO Auto-generated method stub
	Course course1 = new Course("Web Services in 10 steps");
	entityManager.persist(course1);
	course1.setName(null);

}

}
