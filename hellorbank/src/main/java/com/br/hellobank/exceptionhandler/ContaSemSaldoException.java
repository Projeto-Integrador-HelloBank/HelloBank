package com.br.hellobank.exceptionhandler;

public class ContaSemSaldoException extends RuntimeException {
	
	public ContaSemSaldoException(String mensagem) {
		super(mensagem);
	}

	private static final long serialVersionUID = 1L;

}
