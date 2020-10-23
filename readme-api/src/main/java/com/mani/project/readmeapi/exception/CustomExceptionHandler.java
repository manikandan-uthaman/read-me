package com.mani.project.readmeapi.exception;

import javax.validation.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(IllegalArgumentException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public ApplicationError handleIllegalArgumentException(IllegalArgumentException ex, HandlerMethod handler) {
		return new ApplicationError(ErrorCode.INVALID_INPUT.getCode(), ex.getMessage());
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ApplicationError handleResourceNotFoundException(ResourceNotFoundException ex, HandlerMethod handler) {
		return new ApplicationError(ErrorCode.NOT_FOUND.getCode(), ex.getMessage());
	}

	@ExceptionHandler(ValidationException.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApplicationError handleException(ValidationException ex, HandlerMethod handler) {
		return new ApplicationError(ErrorCode.UNKNOWN_EXCEPTION.getCode(), ex.getCause().getMessage());
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ApplicationError handleException(Exception ex, HandlerMethod handler) {
		return new ApplicationError(ErrorCode.UNKNOWN_EXCEPTION.getCode(), "Something went wrong..");
	}
	
}
