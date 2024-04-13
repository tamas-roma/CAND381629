package com.surveysampling.inverviewtest.cardatabase.service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveysampling.inverviewtest.cardatabase.exception.InvalidSearchRequestException;
import com.surveysampling.inverviewtest.cardatabase.mapper.CarMapper;
import com.surveysampling.inverviewtest.cardatabase.model.Car;
import com.surveysampling.inverviewtest.cardatabase.model.request.SearchedCarsRequest;
import com.surveysampling.inverviewtest.cardatabase.model.response.SerchedCarsReponse;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarRepository;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarsOfPeopleRepository;

@Component
public class CarServiceImpl implements CarService {

	@Autowired
	private CarsOfPeopleRepository carsOfPeopleRepository;

	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private CarMapper carMapper;
	
	@Override
	public SerchedCarsReponse getCarsByUserIdOrCarId(SearchedCarsRequest searchedCarsRequest) throws InvalidSearchRequestException {
		validateRequest(searchedCarsRequest);
		List<BigDecimal> carIds = getCarIds(searchedCarsRequest);
		return searchCarsByIds(carIds);
	}

	private void validateRequest(SearchedCarsRequest searchedCarsRequest) throws InvalidSearchRequestException {
		if (searchedCarsRequest.getCarId() != null && searchedCarsRequest.getPersonId() != null) {
			throw new InvalidSearchRequestException("Search allowed by UserID or CarId!");
		} else if (searchedCarsRequest.getCarId() == null && searchedCarsRequest.getPersonId() == null) {
			throw new InvalidSearchRequestException("No UserID or CarId given!");
		}
	}
	
	private List<BigDecimal> getCarIds(SearchedCarsRequest searchedCarsRequest) {
		List<BigDecimal> carIds;
		if (searchedCarsRequest.getPersonId() != null) {
			carIds = carsOfPeopleRepository.findByCarsOfPeopleId_PersonId(searchedCarsRequest.getPersonId())
					.stream()
					.map(e->e.getCarsOfPeopleId().getCarId())
					.collect(Collectors.toList());
		} else {
			carIds = Arrays.asList(searchedCarsRequest.getCarId());
		}
		return carIds;
	}

	private SerchedCarsReponse searchCarsByIds(List<BigDecimal> carIds) {
		List<Car> cars = carRepository.findByCarIdIn(carIds);
		return new SerchedCarsReponse(carMapper.carsToSearcehdCars(cars));
	}
	
}
