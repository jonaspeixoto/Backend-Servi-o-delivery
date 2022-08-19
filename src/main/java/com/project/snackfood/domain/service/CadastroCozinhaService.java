package com.project.snackfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.project.snackfood.domain.exception.EntidadeEmUsoException;
import com.project.snackfood.domain.exception.EntidadeNaoEncotradaException;
import com.project.snackfood.domain.model.Cozinha;
import com.project.snackfood.domain.repository.CozinhaRepository;

@Service // é um componente também mais especificada como serviço
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Cozinha salvar(Cozinha cozinha){
		return cozinhaRepository.salvar(cozinha);
		
	}
	
	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		}catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncotradaException(
					String.format("Nao existe um cadastro de cozinha com o codifo %d", cozinhaId));
		}
		catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("cozinha de codigo %d não pode ser removida, pois está em uso"
							, cozinhaId));
		}
	}
}
