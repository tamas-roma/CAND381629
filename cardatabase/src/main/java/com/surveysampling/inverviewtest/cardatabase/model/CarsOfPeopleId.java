package com.surveysampling.inverviewtest.cardatabase.model;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

@Embeddable
public class CarsOfPeopleId {

	private BigDecimal personId;
	private BigDecimal carId;

	public CarsOfPeopleId() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPersonId() {
		return personId;
	}

	public void setPersonId(BigDecimal personId) {
		this.personId = personId;
	}

	public BigDecimal getCarId() {
		return carId;
	}

	public void setCarId(BigDecimal carId) {
		this.carId = carId;
	}
	
}
