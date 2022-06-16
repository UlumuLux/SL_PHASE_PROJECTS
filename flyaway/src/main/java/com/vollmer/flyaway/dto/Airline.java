package com.vollmer.flyaway.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "airlines")
@Table(name = "airlines")
public class Airline implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Airline() {
		
	}
	
	public Airline(String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "airline_id")
	protected int id;

	@Column(name = "airline_name")
	protected String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
