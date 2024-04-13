package com.surveysampling.inverviewtest.cardatabase.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysampling.inverviewtest.cardatabase.model.CarsOfPeople;
import com.surveysampling.inverviewtest.cardatabase.model.CarsOfPeopleId;

public interface CarsOfPeopleRepository extends JpaRepository<CarsOfPeople, CarsOfPeopleId> {

	List<CarsOfPeople> findByCarsOfPeopleId_PersonId(BigDecimal personId);
	
}
