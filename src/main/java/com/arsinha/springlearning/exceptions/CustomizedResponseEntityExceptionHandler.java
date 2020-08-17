package com.arsinha.springlearning.exceptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.arsinha.springlearning.model.ApplicationError;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object>handleAllExceptions(Exception e,WebRequest req){
		List<String> errors= new ArrayList<>();
		errors.add("Student not found "+e.getMessage());
		
		return new ResponseEntity<Object>(new ApplicationError(errors, new Date(), HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object>handleStudentNotFoundExceptions(StudentNotFoundException ex,WebRequest req){
		List<String> errors= new ArrayList<>();
		errors.add("Student not found "+ex.getMessage());
		return new ResponseEntity<Object>(new ApplicationError(errors, new Date(), HttpStatus.NOT_FOUND),HttpStatus.NOT_FOUND);
	}
	
	 @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        for(ObjectError error : ex.getBindingResult().getAllErrors()) {
	            details.add(error.getDefaultMessage());
	        }
	        ApplicationError error = new ApplicationError(details,new Date(),HttpStatus.BAD_REQUEST);
	        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	    }
	 
	
}
