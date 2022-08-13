package com.project.snackfood.domain.repository;

import java.util.List;

import com.project.snackfood.domain.model.Permisao;

public interface PermisaoRepository {
	
	List<Permisao>listar();
	Permisao buscar(Long id);
	Permisao salvar(Permisao permisao);
	void remover(Permisao permisao);
}


