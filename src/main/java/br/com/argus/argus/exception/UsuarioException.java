package br.com.argus.argus.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UsuarioException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioException() {
		super();
	}
	
	public UsuarioException(String mensagem) {
		super(mensagem);
	}
	
	public UsuarioException(String message, Throwable cause) {
        super(message, cause);
    }
	
    public UsuarioException(Throwable cause) {
        super(cause);
    }
	

}
