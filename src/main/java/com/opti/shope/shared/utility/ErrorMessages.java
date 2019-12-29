package com.opti.shope.shared.utility;

public enum ErrorMessages {
	RECORD_ALREADY_EXISTED("Record already existed !"),
	PROVIDE_USER_ID("Please provide user id."),
	UNKNOWN_EXCEPION_OCCUED("Unkonwn excepion occued please try again");

	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
