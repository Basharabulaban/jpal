package com.densin.rws.jdbctojpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity

//@NamedQueries(value = {
//
//		@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c"),
//		@NamedQuery(name = "query_get_specfic_steps", query = "Select c from Course c where name like '%100 steps'")
//
//})

public class Passport {
	@Id
	@GeneratedValue
	private Long id;
	// for @Column you can use unique , nullable, insertable,
	// updatable,length,precision, scall

	// @Column(name="fullname",nullable = false) // name can not have null value
	
	@Column(nullable = false)
	private String number;

	 public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	@OneToOne(fetch=FetchType.LAZY, mappedBy = "passport")// add mappedBy and passport variable;;;; is from student class to cosnider  the stundet class or table is the main our owner side relationship 
	// now re run the application , you will see the student table has the passport id  , but the passport doesnot has student id
	private Student student ;
	
	@Override
	public String toString() {
		return "Passport [number=" + number + "]";
	}

	
	protected Passport() {
		// super();
	}

	public Passport(String number) {
		this.number = number;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

}
