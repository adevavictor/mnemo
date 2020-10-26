package com.mnemo.application.utils;

import java.sql.Timestamp;
import java.util.Date;

import com.mnemo.application.exception.model.ExceptionModel;

public class Utils {
	
	public static ExceptionModel buildException(Integer status, String message) {
		return new ExceptionModel(status, message, new Timestamp(new Date().getTime()));
	}
}
