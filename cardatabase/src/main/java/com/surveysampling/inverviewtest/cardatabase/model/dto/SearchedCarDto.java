package com.surveysampling.inverviewtest.cardatabase.model.dto;

import java.math.BigDecimal;

public class SearchedCarDto {

	private BigDecimal carId;
	private String brand;
	private String type;
	private String	plateNumber;
	private Integer yearOfManufacture;
	private BigDecimal calculatedValue;
	private BigDecimal drivenDistance;
	
	public SearchedCarDto() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getCarId() {
		return carId;
	}

	public void setCarId(BigDecimal carId) {
		this.carId = carId;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public Integer getYearOfManufacture() {
		return yearOfManufacture;
	}

	public void setYearOfManufacture(Integer yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}

	public BigDecimal getCalculatedValue() {
		return calculatedValue;
	}

	public void setCalculatedValue(BigDecimal calculatedValue) {
		this.calculatedValue = calculatedValue;
	}

	public BigDecimal getDrivenDistance() {
		return drivenDistance;
	}

	public void setDrivenDistance(BigDecimal drivenDistance) {
		this.drivenDistance = drivenDistance;
	}
	
}
