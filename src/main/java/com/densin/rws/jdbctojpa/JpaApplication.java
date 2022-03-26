package com.densin.rws.jdbctojpa;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.densin.rws.jdbctojpa.jpa.PersonJpaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;




import net.bytebuddy.asm.Advice.This;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(This.class);
 @Autowired
 PersonJpaRepository repository;
 



	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
	//	logger.info("All Users -> {}",	repository.findAll());
		logger.info("userid 1 -> {} ",	repository.findbyId(1));
	//	logger.info("users by -> {} ",	repository.findbylocation("Amman"));
	}

}
