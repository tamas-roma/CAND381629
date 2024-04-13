package com.surveysampling.inverviewtest.cardatabase.service;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.model.Car;
import com.surveysampling.inverviewtest.cardatabase.model.EmailTemplate;
import com.surveysampling.inverviewtest.cardatabase.model.PersonData;
import com.surveysampling.inverviewtest.cardatabase.model.dto.EmailDataDto;

@Component
public class EmailTemplateFillerImpl implements EmailTemplateFiller {

	@Autowired
	private EmailTemplateService emailTemplateService;

	//TODO Date format should come from database
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	@Override
	public String getFilledTemplate(EmailDataDto emailData) throws MissingLanguageException {
		EmailTemplate emailTemplate = emailTemplateService.getEmailTemplateByLanguageId(emailData.getPersonData().getLanguageId());
		String template = emailTemplate.getText();
		
		String loopStartTag = "<carsLoopBegin>";
		String loopEndTag = "<carsLoopEnd>";
		
		int loopStartPos = template.indexOf(loopStartTag);
		int loopEndPos = template.indexOf(loopEndTag);

		String templateHeader = template.substring(0, loopStartPos);
		String templateContent = template.substring(loopStartPos+loopStartTag.length(), loopEndPos);
		String templateFooter = template.substring(loopEndPos+loopEndTag.length());
		
		StringBuilder filledTemplate = new StringBuilder();
		filledTemplate.append(fillHeader(emailData.getPersonData(), templateHeader));
		filledTemplate.append(fillContent(emailData.getCars(), templateContent));
		filledTemplate.append(fillFootear(templateFooter));
		return filledTemplate.toString();
	}

	private String fillHeader(PersonData personData, String templateHeader) {
		return templateHeader.replace("<name>", personData.getName())
				.replace("<country>", personData.getCountry())
				.replace("<dateOfBirth>", formatter.format(personData.getDataOfBirht()));
	}

	private String fillContent(List<Car> cars, String templateContent) {
		StringBuilder content = new StringBuilder();
		for (Car car : cars) {
			content.append(templateContent.replace("<brand>", car.getBrand())
					.replace("<type>", car.getType())
					.replace("<plateNumber>", car.getPlateNumber())
					.replace("<yearOfManufacture>", car.getYearOfManufacture().toString())
					.replace("<drivenDistance>", car.getDrivenDistance().toString())
					.replace("<calculatedValue>", car.getCalculatedValue().toString()));
		}
		return content.toString();
	}

	private String fillFootear(String templateFooter) {
		return templateFooter;
	}
	
}
