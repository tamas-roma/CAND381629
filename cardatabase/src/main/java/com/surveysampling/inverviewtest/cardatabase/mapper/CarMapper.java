package com.surveysampling.inverviewtest.cardatabase.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.surveysampling.inverviewtest.cardatabase.model.Car;
import com.surveysampling.inverviewtest.cardatabase.model.dto.SearchedCarDto;

@Mapper(componentModel = "spring")
public interface CarMapper {

	SearchedCarDto carToSearcehdCar(Car car);
	
	List<SearchedCarDto> carsToSearcehdCars(List<Car> car);
	
}
