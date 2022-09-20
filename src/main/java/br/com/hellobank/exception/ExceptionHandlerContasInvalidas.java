package br.com.hellobank.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerContasInvalidas extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ ContaSemSaldoException.class })
	public ResponseEntity<Object> handleContaSemSaldoException(ContaSemSaldoException ex) {
		String mensagemUsuario = "Saldo Insuficiente";
		String mensagemDesenvolvedor = ex.toString();
		List<TExceptionHandler.Erro> erros = Arrays
				.asList(new TExceptionHandler.Erro(mensagemUsuario, mensagemDesenvolvedor));
		System.out.println("Passou erro conta");
		return ResponseEntity.badRequest().body(erros);
	}
}
