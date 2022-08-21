package com.project.snackfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.snackfood.domain.exception.EntidadeNaoEncotradaException;
import com.project.snackfood.domain.model.Cozinha;
import com.project.snackfood.domain.model.Restaurante;
import com.project.snackfood.domain.repository.CozinhaRepository;
import com.project.snackfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {
	
	@Autowired 
	RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);
		
		if (cozinha == null) {
			throw new EntidadeNaoEncotradaException(
				String.format("Não existe cadasto de cozinha com o codigo %d",cozinhaId));
		}
		restaurante.setCozinha(cozinha);
		
		return restauranteRepository.salvar(restaurante);
	}
}
