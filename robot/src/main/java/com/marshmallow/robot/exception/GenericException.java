package com.marshmallow.robot.exception;

public class GenericException extends RuntimeException {

	public GenericException(String message) {
		super(message);
	}

	public GenericException(String message, int oilPatchIndex) {
		super(message + oilPatchIndex);
	}

}
