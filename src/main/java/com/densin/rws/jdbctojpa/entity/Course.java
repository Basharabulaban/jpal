package com.densin.rws.jdbctojpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
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
