package com.opti.shope.service.exception;

public class UserServiceException extends RuntimeException{
	private static final long serialVersionUID = -879313250652130413L;

	public UserServiceException(String exception){
		super(exception);
	}
}
