package com.surveysampling.inverviewtest.cardatabase.service;

import org.springframework.stereotype.Service;

@Service
public interface EmailSender {

	void sendEmailTo(String emailAdress, String content);
	
}
