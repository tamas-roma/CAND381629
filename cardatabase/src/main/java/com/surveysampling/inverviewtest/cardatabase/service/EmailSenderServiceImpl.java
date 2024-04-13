package com.surveysampling.inverviewtest.cardatabase.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.surveysampling.inverviewtest.cardatabase.exception.MissingLanguageException;
import com.surveysampling.inverviewtest.cardatabase.exception.NoCarFoundException;
import com.surveysampling.inverviewtest.cardatabase.model.Car;
import com.surveysampling.inverviewtest.cardatabase.model.PersonData;
import com.surveysampling.inverviewtest.cardatabase.model.dto.EmailDataDto;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarRepository;
import com.surveysampling.inverviewtest.cardatabase.repositories.CarsOfPeopleRepository;
import com.surveysampling.inverviewtest.cardatabase.repositories.PersonDataRepository;

@Component
public class EmailSenderServiceImpl implements EmailSenderService {

	@Value("${demo.mode}")
	private boolean demoMode;
	
	@Autowired
	private CarsOfPeopleRepository carsOfPeopleRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private PersonDataRepository personDataRepository;
	
	@Autowired
	private EmailTemplateFiller emailTemplateFiller;
	
	@Autowired
	private EmailSender emailSender;
	
	@Override
	public void sendEmailToUser(BigDecimal userId) throws NoCarFoundException, MissingLanguageException {
		EmailDataDto emailData = getUserCars(userId);
		String emailContent = emailTemplateFiller.getFilledTemplate(emailData);
		emailSender.sendEmailTo("No-email found in stored data!", emailContent);
		if (!demoMode) {
			updateCarsToSent(emailData.getCars());
		}
	}
	
	public EmailDataDto getUserCars(BigDecimal userId) throws NoCarFoundException {
		List<BigDecimal> carIds = carsOfPeopleRepository.findByCarsOfPeopleId_PersonId(userId)
				.stream()
				.map(e -> e.getCarsOfPeopleId().getCarId())
				.toList();
		if(carIds.isEmpty()) {
			throw new NoCarFoundException("Tehere are no car(s) found!");
		}
		List<Car> cars = carRepository.findAllByCarIdInAndCalculatedValueGreaterThanAndSentNot(carIds, 0, true);
		if (cars.isEmpty()) {
			throw new NoCarFoundException("Tehere are no car(s) found!");
		}
		Optional<PersonData> person = personDataRepository.findById(userId);
		return new EmailDataDto(person.get(), cars);
	}

	private void updateCarsToSent(List<Car> cars) {
		for (Car car : cars) {
			car.setSent(true);
		}
		carRepository.saveAllAndFlush(cars);
	}
	
}
