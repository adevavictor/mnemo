package com.mnemo.application.exception.handler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.mnemo.application.exception.NotFoundException;
import com.mnemo.application.utils.Utils;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { NotFoundException.class })
	protected ResponseEntity<Object> handleNumberFormatException(RuntimeException ex, WebRequest request) {
		return handleExceptionInternal(ex, Utils.buildException(HttpStatus.NOT_FOUND.value(), ex.getMessage()), 
				new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}