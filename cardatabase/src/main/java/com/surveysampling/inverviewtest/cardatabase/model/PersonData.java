package com.surveysampling.inverviewtest.cardatabase.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "PERSON_DATA")
public class PersonData {

	@Id
	private BigDecimal personId;
	private String name;
	private LocalDate dataOfBirht;     
	private String country;
	private BigDecimal languageId;
	
	public PersonData() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getPersonId() {
		return personId;
	}

	public void setPersonId(BigDecimal personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDataOfBirht() {
		return dataOfBirht;
	}

	public void setDataOfBirht(LocalDate dataOfBirht) {
		this.dataOfBirht = dataOfBirht;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}
	
}
