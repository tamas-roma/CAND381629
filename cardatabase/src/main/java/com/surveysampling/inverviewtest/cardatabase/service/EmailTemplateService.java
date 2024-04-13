package com.surveysampling.inverviewtest.cardatabase.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.model.EmailTemplate;

@Service
public interface EmailTemplateService {

	EmailTemplate getEmailTemplateByLanguageId(BigDecimal id) throws MissingLanguageException;
	
}
