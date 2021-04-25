package com.opti.shope.shared.utility;

public enum ErrorMessages {
	RECORD_ALREADY_EXISTED("Record already existed !"),
	PROVIDE_USER_ID("Please provide user id."),
	FILE_NOT_UPLOADED("Pease attach the file."),
	FILE_NAME_INVALID("Sorry ! File name contains invalid path sequence"),
	FILE_FORMAT_MUST_BE_PNG_JPG("File format should be .jpg or .jpeg or .png"),
	UNKNOWN_EXCEPION_OCCUED("Unkonwn excepion occued please try again");

	private String errorMessage;
	
	ErrorMessages(String errorMessage){
		this.errorMessage=errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}
