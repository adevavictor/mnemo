package com.mnemo.application.enums;

import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.util.StringUtils;

public enum UserFilter {
	
	NA("", ValidationType.NA), 
	ID("id", ValidationType.NUMERIC), 
	NAME("name", ValidationType.STRING), 
	SURNAME("surname", ValidationType.STRING), 
	CODE("code", ValidationType.STRING), 
	GROUP_ID("groups_id", ValidationType.NUMERIC), 
	GROUP_NAME("groups_name", ValidationType.STRING);
	
	private String name;
	private ValidationType validationType;
	
	private UserFilter(String name, ValidationType validationType) {
		this.name = name;
		this.validationType = validationType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ValidationType getValidationType() {
		return validationType;
	}

	public void setValidationType(ValidationType validationType) {
		this.validationType = validationType;
	}

	public static boolean isValid(ValidationType validationType, Optional<String> value) {
		boolean result = false;
		
		switch(validationType) {
			case STRING:
				result = !StringUtils.isEmpty(value.get());
				break;
			case NUMERIC:
				result = !StringUtils.isEmpty(value.get()) && Pattern.matches("^-?\\d{1,19}$", value.get());
				break;
			case NA:
			default:
				break;
		}
		
		return result;
	}
	
	public static UserFilter getFilter(String type) {
		if (StringUtils.isEmpty(type)) {
			return UserFilter.NA;
		}
		
		for (UserFilter filter: UserFilter.values()) {
			if (type.equalsIgnoreCase(filter.getName())) {
				return filter;
			}
		}
		
		return UserFilter.NA;
	}
}
