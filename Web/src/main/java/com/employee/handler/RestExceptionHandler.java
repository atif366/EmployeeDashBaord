package com.employee.handler;


import com.employee.constants.DashBoardConstants;
import com.employee.exception.*;
import com.employee.response.ResponseDTO;
import com.employee.util.ResponseUtil;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.naming.AuthenticationException;
import javax.naming.NamingSecurityException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler  {
	

	private final ResponseUtil responseUtil;

	public RestExceptionHandler(ResponseUtil responseUtil) {
		this.responseUtil = responseUtil;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	protected ResponseDTO handleMissingServletRequestParameter(MissingServletRequestParameterException ex) {
		String error = ex.getParameterName() + " parameter is missing";
		ApiError  apiError=new ApiError(BAD_REQUEST, error, ex);
		apiError.setResponseCode(DashBoardConstants.BAD_REQUEST);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseBody
	protected ResponseDTO handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
		return buildResponseEntity(
				new ApiError(HttpStatus.UNSUPPORTED_MEDIA_TYPE, builder.substring(0, builder.length() - 2), ex));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	protected ResponseDTO handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		ApiError apiError = new ApiError(BAD_REQUEST);
		apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(javax.validation.ConstraintViolationException.class)
	@ResponseBody
	protected ResponseDTO handleConstraintViolation(javax.validation.ConstraintViolationException ex) {
		ApiError apiError = new ApiError(BAD_REQUEST);
        apiError.setMessage("Validation error");
		apiError.addValidationErrors(ex.getConstraintViolations());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(UserNameNotFOundException.class)
	@ResponseBody
	protected ResponseDTO handleConstraintViolation(UserNameNotFOundException ex) {
		ApiError apiError = new ApiError(FORBIDDEN);
        apiError.setMessage("Failed Authorization");
		apiError.addValidationError("Authrization", "UserName/Password", "Not Authorized", ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(NamingSecurityException.class)
	@ResponseBody
	protected ResponseDTO handleConstraintViolation(NamingSecurityException ex) {
		ApiError apiError = new ApiError(FORBIDDEN);
        apiError.setMessage("Failed Authorization");
		apiError.addValidationError("Authrization", "UserName/Password", "Not Authorized", ex.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseBody
	protected ResponseDTO handleEntityNotFound(EntityNotFoundException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseBody
	protected ResponseDTO handleDataIntegrityViolation(DataIntegrityViolationException ex,
			WebRequest request) {
		if (ex.getCause() instanceof ConstraintViolationException) {
			return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, "Database error", ex.getCause()));
		}
		return buildResponseEntity(new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex));
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	@ResponseBody
	protected ResponseDTO handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(BAD_REQUEST,ex);
        apiError.setMessage(String.format("The parameter '%s' of value '%s' could not be converted to type '%s'",
				ex.getName(), ex.getValue(), ex.getRequiredType().getSimpleName()));
		apiError.setDebugMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(EntityNotSavedException.class)
	@ResponseBody
	protected ResponseDTO errorWhileSave(EntityNotSavedException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex);
        apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}

	private ResponseDTO buildResponseEntity(ApiError apiError) {
		return responseUtil.createResponseDto(apiError.getMessage(), apiError.getStatusCode(), apiError);
	}
	
	@ExceptionHandler(EntityNotDeletedException.class)
	@ResponseBody
	protected ResponseDTO errorWhileDelete(EntityNotDeletedException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST,ex);
        apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
	
	@ExceptionHandler(EntityAlredyExistsException.class)
	@ResponseBody
	protected ResponseDTO invalidInput(EntityAlredyExistsException ex,
			WebRequest request) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
        apiError.setMessage(ex.getMessage());
		return buildResponseEntity(apiError);
	}
	
}
