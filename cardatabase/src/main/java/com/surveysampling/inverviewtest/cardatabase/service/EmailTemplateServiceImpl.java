package com.surveysampling.inverviewtest.cardatabase.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.model.EmailTemplate;
import com.surveysampling.inverviewtest.cardatabase.repositories.EmailTemplateRepository;

@Component
public class EmailTemplateServiceImpl implements EmailTemplateService {

	private Map<BigDecimal, EmailTemplate> cache = new HashMap<>();
	
	@Autowired
	private EmailTemplateRepository emailTemplateRepository;
	
	@Override
	public EmailTemplate getEmailTemplateByLanguageId(BigDecimal id) throws MissingLanguageException {
		EmailTemplate cachedTemplate = cache.get(id);
		if (cachedTemplate == null) {
			Optional<EmailTemplate> template = emailTemplateRepository.findById(id);
			if (template.isEmpty()) {
				throw new MissingLanguageException("Requested language is missing! Language: " + id);
			}
			cachedTemplate = template.get();
			cache.put(id, cachedTemplate);
		}
		return cachedTemplate;
	}

}
