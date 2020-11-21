package com.marshmallow.robot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.marshmallow.robot.exception.GenericException;
import com.marshmallow.robot.exception.RobotCustomError;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		final List<ObjectError> fieldErrors = ex.getBindingResult().getAllErrors();
		final List<RobotCustomError> customFieldErrors = new ArrayList<>();

		for (ObjectError fieldError : fieldErrors) {
			final String field = fieldError.getCode();
			final String message = fieldError.getDefaultMessage();
			final RobotCustomError customFieldError = RobotCustomError.builder().field(field).message(message).build();

			customFieldErrors.add(customFieldError);
		}
		return ResponseEntity.badRequest().body(customFieldErrors);
	}

	@ExceptionHandler(GenericException.class)
	public final ResponseEntity<Object> handleGenericError(GenericException ex, WebRequest request) {

		return new ResponseEntity<>(RobotCustomError.builder().message(ex.getMessage()).build(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
