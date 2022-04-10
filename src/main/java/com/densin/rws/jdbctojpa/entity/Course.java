package com.densin.rws.jdbctojpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
//@Table(name="CourseDetails")   //  the name of the table is course_details  
//@Table(name="Course")   //  you can copmment this as table and class is the same

public class Course {
	@Id
	@GeneratedValue
	private Long id;
	//for @Column   you can use unique , nullable, insertable, updatable,length,precision, scall
	
	// @Column(name="fullname",nullable = false) // name can not have null value
	@Column(nullable = false) 
	private String name;
	
	
	
	
	private LocalDateTime lastUpdateDate;
	private LocalDateTime createDate;
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
//	@Override
//	public String toString() {
//		return String.format("Course [%s]",name);
//	}
	
	protected Course() {
		//super();
	}
	public Course(String name) {
		this.name=name;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	
	

}
