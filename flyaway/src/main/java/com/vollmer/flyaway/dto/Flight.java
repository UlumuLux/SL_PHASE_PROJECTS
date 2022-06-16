package com.vollmer.flyaway.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "flights")
@Table(name = "flights")
public class Flight implements Serializable {

	private static final long serialVersionUID = 1L;

	public Flight() {
		
	}
	
	public Flight(String source, String dest, String airline, String date, String time, double price) {
		super();
		this.source = source;
		this.dest = dest;
		this.airline = airline;
		this.date = date;
		this.time = time;
		this.price = price;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "flight_id")
	protected int id;
	
	@Column(name = "flight_source")
	protected String source;
	
	@Column(name = "flight_dest")
	protected String dest;
	
	@Column(name = "flight_airline")
	protected String airline;
	
	@Column(name = "flight_date")
	protected String date;
	
	@Column(name = "flight_time")
	protected String time;
	
	@Column(name = "flight_price")
	protected double price;
	
	// GETTERS AND SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
