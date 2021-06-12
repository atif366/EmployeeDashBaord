package com.employee.exception;

public class EntityNotSavedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7000452552989196981L;

	public EntityNotSavedException() {
		super();
	}

	public EntityNotSavedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotSavedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotSavedException(String message) {
		super(message);
	}

	public EntityNotSavedException(Throwable cause) {
		super(cause);
	}

}
