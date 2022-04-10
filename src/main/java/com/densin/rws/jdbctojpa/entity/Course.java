package com.densin.rws.jdbctojpa.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
//@Table(name="CourseDetails")   //  the name of the table is course_details  
//@Table(name="Course")   //  you can copmment this as table and class is the same

//// i see such named query were working even i do not use NamedQueries
//@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c")
//@NamedQuery(name = "query_get_specfic_steps", query = "Select c from Course c where name like '%100 steps'")

@NamedQueries(value = {

		@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c"),
		@NamedQuery(name = "query_get_specfic_steps", query = "Select c from Course c where name like '%100 steps'")

})
public class Course {
	@Id
	@GeneratedValue
	private Long id;
	// for @Column you can use unique , nullable, insertable,
	// updatable,length,precision, scall

	// @Column(name="fullname",nullable = false) // name can not have null value
	@Column(nullable = false)
	private String name;

	@UpdateTimestamp
	private LocalDateTime lastUpdateDate;

	@CreationTimestamp
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
		// super();
	}

	public Course(String name) {
		this.name = name;

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
