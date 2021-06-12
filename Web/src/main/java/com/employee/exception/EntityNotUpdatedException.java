package com.employee.exception;

public class EntityNotUpdatedException extends Exception {

	private static final long serialVersionUID = 3876375859832586649L;

	public EntityNotUpdatedException() {
		super();
	}

	public EntityNotUpdatedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotUpdatedException(String message) {
		super(message);
	}

	public EntityNotUpdatedException(Throwable cause) {
		super(cause);
	}

}
