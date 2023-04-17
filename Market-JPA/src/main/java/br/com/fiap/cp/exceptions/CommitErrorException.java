package br.com.fiap.cp.exceptions;

public class CommitErrorException extends Exception {
	private static final long serialVersionUID = 1L;

	public CommitErrorException() {
		super("Erro ao realizar o commit");
	}
	
	public CommitErrorException(String msg) {
		super(msg);
	}

}
