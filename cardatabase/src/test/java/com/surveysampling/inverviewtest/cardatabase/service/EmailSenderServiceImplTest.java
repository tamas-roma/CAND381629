package com.surveysampling.inverviewtest.cardatabase.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surveysampling.inverviewtest.cardatabase.exception.NoCarFoundException;
import com.surveysampling.inverviewtest.cardatabase.model.CarsOfPeople;
import com.surveysampling.inverviewtest.cardatabase.model.CarsOfPeopleId;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarRepository;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarsOfPeopleRepository;

@ExtendWith(MockitoExtension.class)
class EmailSenderServiceImplTest {

	@InjectMocks
	EmailSenderServiceImpl service;
	
	@Mock
	CarsOfPeopleRepository carsOfPeopleRepository;
	
	@Mock
	CarRepository carRepository;
	
	@Test
	void test_NO_USER_sendEmailToUser() {

		when(carsOfPeopleRepository.findByCarsOfPeopleId_PersonId(any())).thenReturn(Collections.emptyList());

		NoCarFoundException exception = assertThrows(NoCarFoundException.class, () -> {
			service.getUserCars(new BigDecimal("1"));
		});
		
		assertEquals("Tehere are no car(s) found!", exception.getMessage());
	}

	@Test
	void test_NO_CAR_sendEmailToUser() {

		List<CarsOfPeople> ret = new ArrayList<>();
		CarsOfPeople carsOfPeople = new CarsOfPeople();
		CarsOfPeopleId carsOfPeopleId = new CarsOfPeopleId();
		carsOfPeopleId.setCarId(new BigDecimal("1"));
		carsOfPeopleId.setPersonId(new BigDecimal("1"));
		carsOfPeople.setCarsOfPeopleId(carsOfPeopleId);
		
		ret.add(carsOfPeople);
		when(carsOfPeopleRepository.findByCarsOfPeopleId_PersonId(any())).thenReturn(ret);

		when(carRepository.findAllByCarIdInAndCalculatedValueGreaterThanAndSentNot(any(), anyInt(), anyBoolean())).thenReturn(Collections.emptyList());
		
		NoCarFoundException exception = assertThrows(NoCarFoundException.class, () -> {
			service.getUserCars(new BigDecimal("1"));
		});
		assertEquals("Tehere are no car(s) found!", exception.getMessage());
	}
	
}
