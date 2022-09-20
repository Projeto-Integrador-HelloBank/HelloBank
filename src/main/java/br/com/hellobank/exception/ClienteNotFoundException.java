package br.com.hellobank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClienteNotFoundException extends RuntimeException{
   
	private static final long serialVersionUID = 1L;

	public ClienteNotFoundException(Long id) {
        super("Cliente com id " + id + " não existe.");
    }
}
