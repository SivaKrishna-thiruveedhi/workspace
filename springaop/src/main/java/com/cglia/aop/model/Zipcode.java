package com.cglia.aop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Zipcode {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int zipId;
	private String zipcode;
	
	@OneToOne
	private Village village;
		
	public Zipcode() {
		super();
	}
	
	public int getZipId() {
		return zipId;
	}
	public void setZipId(int zipId) {
		this.zipId = zipId;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

}
