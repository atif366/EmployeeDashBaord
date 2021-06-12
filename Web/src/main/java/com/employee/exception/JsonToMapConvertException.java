package com.employee.exception;

public class JsonToMapConvertException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8038161317909652684L;

	public JsonToMapConvertException() {
		super();
	}

	public JsonToMapConvertException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public JsonToMapConvertException(String message, Throwable cause) {
		super(message, cause);
	}

	public JsonToMapConvertException(String message) {
		super(message);
	}

	public JsonToMapConvertException(Throwable cause) {
		super(cause);
	}
	
}
