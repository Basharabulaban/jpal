package com.densin.rws.jdbctojpa;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.densin.rws.jdbctojpa.entity.Course;
import com.densin.rws.jdbctojpa.entity.Person;
import com.densin.rws.jdbctojpa.jpa.PersonJpaRepository;
import com.densin.rws.jdbctojpa.jparepository.CourseRepository;

import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(This.class);
//	private Logger logger = LoggerFactory.getLogger(This.getClass());
 @Autowired
 PersonJpaRepository repository;
 @Autowired
 private CourseRepository courseRepository;
 

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
//	Course courserecord = 	courseRepository.findById(10001L);
//	logger.info("course id -->",courserecord);
//		
//		logger.info("userid 1 -> {} ",	repository.findbyId(1));
//	
//		logger.info("userid 1 -> {} ",	repository.update(new Person("kiki","USA",new Date() )));
//		
//		repository.Deletebyid(101);
//		logger.info("userid 1 -> {} ",	repository.findbyId(1));
//		logger.info("find all {} ",	repository.findAll());
//		
//		logger.info("findById(10001L)-->",courserecord);
//		
//		
//		logger.info("course id = 10001 -> {} ",courseRepository.findById(10001L));
//	//	courseRepository.deleteById(10002L);;
//		logger.info("course id = 10001 -> {} ",courseRepository.findById(10002L));
//		
//		courseRepository.save(new Course("Microservises in 100 steps"));  // this is save new record with .save
//		courseRepository.playWithcreate_updaterecordwithdate();
//		
//		courseRepository.playWithEntityManager();
//		
	
		
		
	}

}
