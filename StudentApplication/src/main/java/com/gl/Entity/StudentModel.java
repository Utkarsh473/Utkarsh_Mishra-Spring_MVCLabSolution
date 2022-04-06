package com.gl.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "StudentDetails")
public class StudentModel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name = "Student_Id")
	private int id;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name= "Department")
	private String deptt;
	
	@Column(name= "Country")
	private String country;

	
	  public StudentModel() { super(); 
	  // TODO Auto-generated constructor stub 
	  }
	 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDeptt() {
		return deptt;
	}

	public void setDeptt(String deptt) {
		this.deptt = deptt;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	

	public int getId() {
		return id;
	}

	

	public StudentModel(String name, String deptt, String country) {
		this.name = name;
		this.deptt = deptt;
		this.country = country;
	}

	@Override
	public String toString() {
		return "StudentModel [id=" + id + ", name=" + name + ", deptt=" + deptt + ", country=" + country + "]";
	}
	
	
	

}
