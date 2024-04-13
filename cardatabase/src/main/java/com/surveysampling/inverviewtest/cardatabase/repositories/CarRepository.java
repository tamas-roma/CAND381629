package com.surveysampling.inverviewtest.cardatabase.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysampling.inverviewtest.cardatabase.model.Car;

public interface CarRepository extends JpaRepository<Car, BigDecimal> {

	List<Car> findAllByCarIdInAndCalculatedValueGreaterThanAndSentNot(List<BigDecimal> carIds, int calculatedValue, boolean sent);

	List<Car> findByCarIdIn(List<BigDecimal> carIds);

}
