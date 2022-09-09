package br.com.hellobank.exception;

public class ContaSemSaldoException extends RuntimeException {
	
	public ContaSemSaldoException(String mensagem) {
		super(mensagem);
	}

	private static final long serialVersionUID = 1L;

}
