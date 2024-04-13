package com.surveysampling.inverviewtest.cardatabase.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.surveysampling.inverviewtest.cardatabase.exception.InvalidSearchRequestException;
import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.exception.NoCarFoundException;
import com.surveysampling.inverviewtest.cardatabase.model.request.SearchedCarsRequest;
import com.surveysampling.inverviewtest.cardatabase.model.response.SerchedCarsReponse;
import com.surveysampling.inverviewtest.cardatabase.service.CarService;
import com.surveysampling.inverviewtest.cardatabase.service.EmailSenderService;

@RestController
public class CardatabaseController {

	@Autowired
	private EmailSenderService emailSenderService; 

	@Autowired
	private CarService carService;
	
	@GetMapping("/send-email-to/{userId}")
	public void sendEmailTo(@PathVariable(name = "userId") String userId) throws NoCarFoundException, MissingLanguageException {
		emailSenderService.sendEmailToUser(new BigDecimal(userId));
	}
	
	@PostMapping("search-cars")
	public SerchedCarsReponse searchCarByUserIdOrCarId(@RequestBody  SearchedCarsRequest searchedCarsRequest) throws InvalidSearchRequestException {
		return carService.getCarsByUserIdOrCarId(searchedCarsRequest);
	}
}
