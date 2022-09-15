package br.com.hellobank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CpfNotFoundException extends RuntimeException{
    
    public CpfNotFoundException(String cpf) {
        super("Cliente com cpf " + cpf + " não existe.");
    }
}
