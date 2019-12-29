package com.opti.shope.service.exception;

import java.util.Date;

public class ServicesException {
	private Date timeStamp;
	private String message;
	private int statusCode;
	private String status;
	

	public ServicesException(Date timeStamp, String message,int statusCode,String status) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.statusCode=statusCode;
		this.setStatus(status);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
