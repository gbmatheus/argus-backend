package br.com.argus.argus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CodigoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CodigoException() {
		super();
	}

	public CodigoException(String mensagem) {
		super(mensagem);
	}

	public CodigoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CodigoException(Throwable cause) {
		super(cause);
	}

}
