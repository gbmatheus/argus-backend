package br.com.argus.argus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MatriculaException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public MatriculaException() {
		super();
	}
	
	public MatriculaException(String mensagem) {
		super(mensagem);
	}
	
	public MatriculaException(String message, Throwable cause) {
        super(message, cause);
    }
	
    public MatriculaException(Throwable cause) {
        super(cause);
    }
	

}
