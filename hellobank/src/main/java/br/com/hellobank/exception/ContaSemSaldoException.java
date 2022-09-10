package br.com.hellobank.exception;

public class ContaSemSaldoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ContaSemSaldoException(String mensagem) {
		super(mensagem);
	}

}
