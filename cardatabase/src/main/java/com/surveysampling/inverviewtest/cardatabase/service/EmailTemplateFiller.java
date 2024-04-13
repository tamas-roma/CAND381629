package com.surveysampling.inverviewtest.cardatabase.service;

import org.springframework.stereotype.Service;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.model.dto.EmailDataDto;

@Service
public interface EmailTemplateFiller {
	
	String getFilledTemplate(EmailDataDto emailData) throws MissingLanguageException;
	
}
