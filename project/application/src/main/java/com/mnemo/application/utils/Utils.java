package com.mnemo.application.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.mnemo.application.exception.model.ExceptionModel;

public class Utils {
	
	public static ExceptionModel buildException(Integer status, String message) {
		return new ExceptionModel(status, message, new Timestamp(new Date().getTime()));
	}
	
	public static String buildRequestErrorMessage(BindingResult result) {
		StringBuilder sb = new StringBuilder();
		
		for (ObjectError error : result.getAllErrors()) {
			sb.append(error.getDefaultMessage());
		}
		
		return sb.toString();
	}
}
