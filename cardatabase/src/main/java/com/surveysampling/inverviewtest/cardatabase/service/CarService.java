package com.surveysampling.inverviewtest.cardatabase.service;

import org.springframework.stereotype.Service;

import com.surveysampling.inverviewtest.cardatabase.exception.InvalidSearchRequestException;
import com.surveysampling.inverviewtest.cardatabase.model.request.SearchedCarsRequest;
import com.surveysampling.inverviewtest.cardatabase.model.response.SerchedCarsReponse;

@Service
public interface CarService {

	SerchedCarsReponse getCarsByUserIdOrCarId(SearchedCarsRequest searchedCarsRequest) throws InvalidSearchRequestException; 
	
}
