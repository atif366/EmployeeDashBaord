package com.employee.exception;

public class MobileNumberAlreadyException extends Exception {
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 7727735596620151957L;

	public MobileNumberAlreadyException() {
		super();
	}

	public MobileNumberAlreadyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MobileNumberAlreadyException(String message, Throwable cause) {
		super(message, cause);
	}

	public MobileNumberAlreadyException(Throwable cause) {
		super(cause);
	}

	public MobileNumberAlreadyException(String string) {
		super(string);
	}

	public MobileNumberAlreadyException(String string, Exception e) {
		super(string, e);
	}



}
