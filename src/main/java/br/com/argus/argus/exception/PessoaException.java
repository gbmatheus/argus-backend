package br.com.argus.argus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PessoaException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PessoaException() {
		super();
	}

	public PessoaException(String msg) {
		super(msg);
	}

	public PessoaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaException(Throwable cause) {
		super(cause);
	}

}
