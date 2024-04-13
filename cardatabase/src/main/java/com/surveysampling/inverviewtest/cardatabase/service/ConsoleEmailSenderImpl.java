package com.surveysampling.inverviewtest.cardatabase.service;

import org.springframework.stereotype.Component;

/**
 * Only for demo!
 */
@Component
@Deprecated
public class ConsoleEmailSenderImpl implements EmailSender {

	@Override
	public void sendEmailTo(String emailAdress, String content) {
		new Exception("Only for demo!!").printStackTrace();
		System.out.println("Sending Email to: " + emailAdress);
		System.out.println(content);
		
	}

}
