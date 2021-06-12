package com.employee.exception;

public class EntityNotFoundException extends Exception {

	public EntityNotFoundException() {
		super();
	}

	public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public EntityNotFoundException(String string) {
		super(string);
	}

	public EntityNotFoundException(String string, Exception e) {
		super(string, e);
	}

	private static final long serialVersionUID = 1L;

}
