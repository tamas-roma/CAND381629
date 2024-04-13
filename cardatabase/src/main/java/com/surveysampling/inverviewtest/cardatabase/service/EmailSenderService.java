package com.surveysampling.inverviewtest.cardatabase.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.exception.NoCarFoundException;

@Service
public interface EmailSenderService {

//	EmailDataDto getUserCars(BigDecimal userId) throws NoCarFoundException;
	
	void sendEmailToUser(BigDecimal userId) throws NoCarFoundException, MissingLanguageException;
	
}
