package com.surveysampling.inverviewtest.cardatabase.model.request;

import java.math.BigDecimal;

public class SearchedCarsRequest {

	private BigDecimal personId;

	private BigDecimal carId;
	
	public SearchedCarsRequest() {
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
