package com.vollmer.flyaway.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "user")
@Table(name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public User() {
		
	}
	
	public User(String uname, String pass, String fname, String lname, String city, String street, String post, String house, String phone, String email, int role) {
		super();
		this.username = uname;
		this.password = pass;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.street = street;
		this.postCode = post;
		this.houseNo = house;
		this.phone = phone;
		this.email = email;
		this.role = role;
	}
	
	public User(String uname, String pass, String fname, String lname, String city, String street, String post, String house, String email, int role) {
		super();
		this.username = uname;
		this.password = pass;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.street = street;
		this.postCode = post;
		this.houseNo = house;
		this.email = email;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	protected int id;

	@Column(name = "username")
	protected String username;
	
	@Column(name = "user_pass")
	protected String password;
	
	@Column(name = "firstname")
	protected String fname;
	
	@Column(name = "lastname")
	protected String lname;
	
	@Column(name = "city")
	protected String city;
	
	@Column(name = "street")
	protected String street;
	
	@Column(name = "postal_code")
	protected String postCode;
	
	@Column(name = "house_no")
	protected String houseNo;
	
	@Column(name = "phone")
	protected String phone;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "has_role")
	protected int role;
	
	/* GETTERS AND SETTERS */ 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
}
