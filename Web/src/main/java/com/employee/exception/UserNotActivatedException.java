package com.employee.exception;

public class UserNotActivatedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8038161317909652684L;

	public UserNotActivatedException() {
		super();
	}

	public UserNotActivatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserNotActivatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserNotActivatedException(String message) {
		super(message);
	}

	public UserNotActivatedException(Throwable cause) {
		super(cause);
	}
	
}
