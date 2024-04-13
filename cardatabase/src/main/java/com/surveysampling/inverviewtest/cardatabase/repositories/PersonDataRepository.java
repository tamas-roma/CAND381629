package com.surveysampling.inverviewtest.cardatabase.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;

import com.surveysampling.inverviewtest.cardatabase.model.PersonData;

public interface PersonDataRepository extends JpaRepository<PersonData, BigDecimal> {

}
