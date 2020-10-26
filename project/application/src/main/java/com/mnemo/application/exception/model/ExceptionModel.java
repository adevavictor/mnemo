package com.mnemo.application.exception.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class ExceptionModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer status;
	private String message;
	private Timestamp timestamp;
	
	public ExceptionModel(Integer status, String message, Timestamp timestamp) {
		this.status = status;
		this.message = message;
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}
