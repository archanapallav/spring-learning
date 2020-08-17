package com.arsinha.springlearning.model;

import java.util.Date;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApplicationError {

	private List<String> message;
	private Date occuredAt;
	private HttpStatus status;
	
	
	public ApplicationError() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ApplicationError(List<String> message, Date occuredAt, HttpStatus status) {
		super();
		this.message = message;
		this.occuredAt = occuredAt;
		this.status = status;
	}
	public List<String> getMessage() {
		return message;
	}
	public void setMessage(List<String> message) {
		this.message = message;
	}
	public Date getOccuredAt() {
		return occuredAt;
	}
	public void setOccuredAt(Date occuredAt) {
		this.occuredAt = occuredAt;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
	
}
