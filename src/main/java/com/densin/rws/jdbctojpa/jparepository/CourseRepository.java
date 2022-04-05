package com.densin.rws.jdbctojpa.jparepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Course;
@Repository
@Transactional

public class CourseRepository {
@Autowired
EntityManager entityManager ;

public Course findById(Long id) {
	return entityManager.find(Course.class, id);
	
}

public Course savebyentity(Course course) {
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



}
