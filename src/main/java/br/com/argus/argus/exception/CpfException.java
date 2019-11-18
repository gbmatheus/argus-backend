package br.com.argus.argus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CpfException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CpfException() {
		super();
	}

	public CpfException(String mensagem) {
		super(mensagem);
	}

	public CpfException(String message, Throwable cause) {
		super(message, cause);
	}

	public CpfException(Throwable cause) {
		super(cause);
	}

}
