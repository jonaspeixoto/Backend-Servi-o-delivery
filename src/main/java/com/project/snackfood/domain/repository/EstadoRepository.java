package com.project.snackfood.domain.repository;

import java.util.List;

import com.project.snackfood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado>listar();
	Estado buscar(Long id);
	Estado salvar(Estado estado);
	void remover(Long id);
}


