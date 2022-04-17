package com.densin.rws.jdbctojpa.jparepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

//import org.apache.logging.log4j.Logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.densin.rws.jdbctojpa.entity.Passport;
import com.densin.rws.jdbctojpa.entity.Student;

import net.bytebuddy.asm.Advice.This;
@Repository
@Transactional

public class StudentRepository {
@Autowired
EntityManager entityManager ;
private Logger logger = LoggerFactory.getLogger(This.class);

public Student findById(Long id) {
	return entityManager.find(Student.class, id);
	
}

public Student save(Student student) {
	if (student.getId()==null) {
		entityManager.persist(student);
	}else {
		entityManager.merge(student);
	}
	return student;
}



public void deleteById(long id) {
	Student student = findById(id);
	
	 entityManager.remove(student) ;
	
}

public void playWithEntityManager() {
	logger.info("playWithEntityManager - start");
	// entityManager.persist(new Student("Web Services in 10 steps"));  // Alt shift l
	
	Student student1 = new Student("Web Services in 10 steps");
	entityManager.persist(student1);
	Student student2 = new Student("React js in 120 steps");
	entityManager.persist(student2); // save or create entity in database
	//    entityManager.merge(student2); // to save the changes that have done to student2 in database
     //  entityManager.remove(student2);  //to delete an entity
//	entityManager.clear();  // per it location afect what to send to database
	entityManager.flush();  // to pass all changes untill now down to databases
//  entityManager.detach(student2);  // this to not send the update to database for student2 
//  entityManager.clear();
	
	
	student2.setName("React js in 120 steps-update");
	entityManager.refresh(student1);  // this to not update the student record to database and refresh the content by original value
	entityManager.flush();  // changes will be send out to databases 
		
}

public void playWithcreate_updaterecordwithdate() {

	//Student student1 = new Student("Web Services in 10 steps");
//	entityManager.persist(student1);
	
	Student student2 = findById(10001L) ;
	
	student2.setName("JPA in 50 steps-update");	
			
}


public void playWithname_setnull() {
	// TODO Auto-generated method stub
	Student student1 = new Student("Web Services in 10 steps");
	entityManager.persist(student1);
	student1.setName(null);

}

public void saveStudentWithPassport() {
	Passport passport=new Passport("Z1234567");
	entityManager.persist(passport);
	Student student1 = new Student("Mike");
	student1.setPassport(passport);
	
	entityManager.persist(student1);
	
//	//Student student2 = new Student("Mike");
//	
//	//entityManager.persist(student2); // save or create entity in database
//	
//	
//	//    entityManager.merge(student2); // to save the changes that have done to student2 in database
//     //  entityManager.remove(student2);  //to delete an entity
////	entityManager.clear();  // per it location afect what to send to database
//	entityManager.flush();  // to pass all changes untill now down to databases
////  entityManager.detach(student2);  // this to not send the update to database for student2 
////  entityManager.clear();
//	
//	
//	student2.setName("React js in 120 steps-update");
//	entityManager.refresh(student1);  // this to not update the student record to database and refresh the content by original value
//	entityManager.flush();  // changes will be send out to databases 
		
}



}
