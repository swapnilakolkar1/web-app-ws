package com.opti.shope.service.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomApplicationExceptionHandler {

	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceExceptions(UserServiceException ex){
		//Handles only UserServiceExceptions
		ServicesException exception=new ServicesException(new Date(),ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(exception,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleOtherException(Exception ex){
		//Handles other exception
		ServicesException exception=new ServicesException(new Date(),ex.toString(),HttpStatus.INTERNAL_SERVER_ERROR.value(),HttpStatus.INTERNAL_SERVER_ERROR.toString());
		return new ResponseEntity<>(exception,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	
		
	}
}
