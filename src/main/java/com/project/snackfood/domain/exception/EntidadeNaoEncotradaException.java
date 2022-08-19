package com.project.snackfood.domain.exception;

public class EntidadeNaoEncotradaException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncotradaException(String mesagem) {
		super(mesagem);
	}
	
}
