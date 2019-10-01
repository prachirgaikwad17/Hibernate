package com.zensar.exceptions;

public class ServiceException extends Exception {

	private String errorMessage;
	
	public ServiceException()
	{
		errorMessage="error: service exception";
	}

	@Override
	public String toString() {
		return "ServiceException [errorMessage=" + errorMessage + "]";
	}

	public ServiceException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}
	
	
	
	
}
