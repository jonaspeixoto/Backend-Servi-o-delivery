package com.project.snackfood.domain.repository;

import java.util.List;

import com.project.snackfood.domain.model.FormaPagamento;

public interface FormaDePagamentoRepository {
	List<FormaPagamento>listar();
	FormaPagamento buscar(Long Id);
	FormaPagamento salvar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);
	 
	
	
}
