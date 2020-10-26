package com.mnemo.application.utils;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.mnemo.application.enums.Order;
import com.mnemo.application.exception.model.ExceptionModel;

public class Utils {
	
	public static Pageable buildPagination(Order order, String property, Integer page) {
		Pageable pageable = null;
		
		switch(order) {
			case ASC:
				pageable = PageRequest.of(page, Constants.PAGE_SIZE, Sort.by(property).ascending());
				break;
			case DESC:
				pageable = PageRequest.of(page, Constants.PAGE_SIZE, Sort.by(property).descending());
				break;
			case NA:
			default:
				pageable = PageRequest.of(page, Constants.PAGE_SIZE, Sort.by(property).descending());
				break;
		}
		
		return pageable;
	}
	
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
