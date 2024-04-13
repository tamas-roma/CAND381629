package com.surveysampling.inverviewtest.cardatabase.model.response;

import java.util.List;

import com.surveysampling.inverviewtest.cardatabase.model.dto.SearchedCarDto;

public class SerchedCarsReponse {

	private List<SearchedCarDto> searchedCars;
	
	public SerchedCarsReponse() {
		// TODO Auto-generated constructor stub
	}

	
	public SerchedCarsReponse(List<SearchedCarDto> searchedCars) {
		super();
		this.searchedCars = searchedCars;
	}

	public List<SearchedCarDto> getSearchedCars() {
		return searchedCars;
	}

	public void setSearchedCars(List<SearchedCarDto> searchedCars) {
		this.searchedCars = searchedCars;
	}
	
}
