package com.surveysampling.inverviewtest.cardatabase.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.model.EmailTemplate;
import com.surveysampling.inverviewtest.cardatabase.repositories.EmailTemplateRepository;

@ExtendWith(MockitoExtension.class)
class EmailTemplateServiceImplTest {

	@InjectMocks
	EmailTemplateServiceImpl service;
	
	@Mock
	EmailTemplateRepository emailTemplateRepository;
	
	@Test
	void test_caching() throws MissingLanguageException {
		EmailTemplate et = new EmailTemplate();
		Optional<EmailTemplate> a = Optional.of(et);
		when(emailTemplateRepository.findById(any())).thenReturn(a);
		
		EmailTemplate t1 = service.getEmailTemplateByLanguageId(new BigDecimal("1"));
		EmailTemplate t2 = service.getEmailTemplateByLanguageId(new BigDecimal("1"));
		
		verify(emailTemplateRepository, times(1)).findById(any());
		assertEquals(t1, t2);
	}

}
