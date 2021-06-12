package com.employee.exception;

public class EntityNotDeletedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5105598397854349121L;

	public EntityNotDeletedException() {
		super();
	}

	public EntityNotDeletedException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public EntityNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public EntityNotDeletedException(String message) {
		super(message);
	}

	public EntityNotDeletedException(Throwable cause) {
		super(cause);
	}

}
