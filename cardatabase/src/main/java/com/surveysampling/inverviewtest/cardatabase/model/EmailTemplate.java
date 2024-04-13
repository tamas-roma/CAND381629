package com.surveysampling.inverviewtest.cardatabase.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name = "EMAIL_TEMPLATES")
public class EmailTemplate {

	@Id
	private BigDecimal languageId;
	
	@Lob
	private String text;
	
	public EmailTemplate() {
		// TODO Auto-generated constructor stub
	}

	public BigDecimal getLanguageId() {
		return languageId;
	}

	public void setLanguageId(BigDecimal languageId) {
		this.languageId = languageId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
