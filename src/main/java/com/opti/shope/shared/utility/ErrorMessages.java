package com.opti.shope.shared.utility;

public enum ErrorMessages {
	RECORD_ALREADY_EXISTED("Record already existed !");

	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
