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

//@NamedQueries(value = {
//
//		@NamedQuery(name = "query_get_all_courses", query = "Select c from Course c"),
//		@NamedQuery(name = "query_get_specfic_steps", query = "Select c from Course c where name like '%100 steps'")
//
//})

public class Review {
	@Id
	@GeneratedValue
	private Long id;
	// for @Column you can use unique , nullable, insertable,
	// updatable,length,precision, scall

	// @Column(name="fullname",nullable = false) // name can not have null value
	
	private String description;

	private String rating;
	
	@Override
	public String toString() {
		return "Review [description=" + description + "]";
	}

	protected Review() {
		// super();
	}

	public Review(String rating,String description) {
		this.setRating(rating);
		this.description = description;

	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
