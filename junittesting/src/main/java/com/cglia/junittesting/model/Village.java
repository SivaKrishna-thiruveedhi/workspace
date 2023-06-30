package com.cglia.junittesting.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Village {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int villageId;
	private String villageName;
	private int population;
	private int status;
	
	public Village() {
		super();
	}
	
	public int getVillageId() {
		return villageId;
	}
	
	public void setVillageId(int villageId) {
		this.villageId = villageId;
	}
	
	public Village(int villageId, String villageName, int population, int status) {
		super();
		this.villageId = villageId;
		this.villageName = villageName;
		this.population = population;
		this.status = status;
	}

	public String getVillageName() {
		return villageName;
	}
	
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	
	public int getPopulation() {
		return population;
	}
	
	public void setPopulation(int population) {
		this.population = population;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}



/*
 * 	{
	    "villageName" : "nandi",
	    "population" : 100000,
	    "status" : 1
	}

*/








