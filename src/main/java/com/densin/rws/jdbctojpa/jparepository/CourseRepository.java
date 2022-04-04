package com.densin.rws.jdbctojpa.jparepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Course;
@Repository


public class CourseRepository {
@Autowired
EntityManager entityManager ;

public Course findById(Long id) {
	return entityManager.find(Course.class, id);
	
}

//public Course save(Course course)
//public void deleteById(Long id)



}
