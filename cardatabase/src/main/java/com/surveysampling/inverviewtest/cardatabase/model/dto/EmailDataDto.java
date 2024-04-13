package com.surveysampling.inverviewtest.cardatabase.model.dto;

import java.util.List;

import com.surveysampling.inverviewtest.cardatabase.model.Car;
import com.surveysampling.inverviewtest.cardatabase.model.PersonData;

public class EmailDataDto {

	private PersonData personData;
	
	private List<Car> cars;
	
	public EmailDataDto() {
		// TODO Auto-generated constructor stub
	}

	public EmailDataDto(PersonData personData, List<Car> cars) {
		super();
		this.personData = personData;
		this.cars = cars;
	}

	public PersonData getPersonData() {
		return personData;
	}

	public void setPersonData(PersonData personData) {
		this.personData = personData;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	
	
}
