package com.employee.exception;

public class EntityAlredyExistsException extends Exception {

	
	private static final long serialVersionUID = -3841677326659278730L;

	public EntityAlredyExistsException() {
		super();
	}

	public EntityAlredyExistsException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public EntityAlredyExistsException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public EntityAlredyExistsException(String arg0) {
		super(arg0);
	}

	public EntityAlredyExistsException(Throwable arg0) {
		super(arg0);
	}

}
