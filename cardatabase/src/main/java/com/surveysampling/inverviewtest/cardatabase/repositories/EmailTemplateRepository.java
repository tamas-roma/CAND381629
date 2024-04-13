package com.surveysampling.inverviewtest.cardatabase.repositories;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.surveysampling.inverviewtest.cardatabase.model.EmailTemplate;

@Repository
public interface EmailTemplateRepository extends JpaRepository<EmailTemplate, BigDecimal> {

}
