package com.vollmer.flyaway.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "destinations")
@Table(name = "destinations")
public class Destination implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Destination() {
		
	}
	
	public Destination(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dest_id")
	protected int id;
	
	@Column(name = "dest_name")
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
