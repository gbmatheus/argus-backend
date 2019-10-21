package br.com.argus.argus.exception;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler{
	
	/**
	 * BindException: exceção lançada quando ocorrem erros fatais de ligação
	 * MethodArgumentNotValidException: exceção lançada quando o argumento 
	 * anotado com @Valid falha  
	 */
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<String>();
		
		//BindException
		for (FieldError error: ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": "+error.getDefaultMessage());
		}
		
		//MethodArgumentNotException
		for (ObjectError error: ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getObjectName() + ": "+error.getDefaultMessage());
		}
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		
		return handleExceptionInternal(ex, apiError, headers, apiError.getStatus(), request);
	}
	
	/**
	 * MissingServletRequestPartExceptio: exceção lançada quando a parte de uma solicitação não é encontrada
	 * MissingServletRequestParameterException: exceção lançada quando o parâmetro da solicitação está ausente
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		String error = ex.getParameterName() + " parameter is missing";
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	/**
	 * ContrainViolationException: exceção relata o resultado de violações de restrição
	 */
	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request){
		List<String> errors = new ArrayList<String>();

		for(ConstraintViolation<?> violation: ex.getConstraintViolations()) {
			errors.add(violation.getRootBeanClass().getName()
					+ " " + violation.getPropertyPath() 
					+ " " + violation.getMessage());
		}
		
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	/**
	 * TypeMismatchExceptio: exceção lançada ao tentar definir a propriedade do bean com o tipo errado
	 * MethodArgumentTypeMismatchException: exceção lançada quando o argumento do método não é do tipo esperado
	 */
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	public ResponseEntity<Object> handlerMethodArgumentTypeMismatch(
			MethodArgumentTypeMismatchException ex, WebRequest request) 
			{
		String error =
		ex.getName() + " should be of type " + ex.getRequiredType().getName();
		
		ApiError apiError =
			new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), error);
		
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	
	
}
