package com.densin.rws.jdbctojpa.entity;

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
	
	
	private String name;
	
	
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
