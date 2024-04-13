package com.surveysampling.inverviewtest.cardatabase.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "CARS_OF_PEOPLE")
public class CarsOfPeople {

	@EmbeddedId
	private CarsOfPeopleId carsOfPeopleId;

	public CarsOfPeople() {
		// TODO Auto-generated constructor stub
	}

	public CarsOfPeopleId getCarsOfPeopleId() {
		return carsOfPeopleId;
	}

	public void setCarsOfPeopleId(CarsOfPeopleId carsOfPeopleId) {
		this.carsOfPeopleId = carsOfPeopleId;
	}


}
