package com.project.snackfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;

import com.project.snackfood.domain.exception.EntidadeEmUsoException;
import com.project.snackfood.domain.exception.EntidadeNaoEncotradaException;
import com.project.snackfood.domain.model.Cidade;
import com.project.snackfood.domain.model.Estado;
import com.project.snackfood.domain.repository.CidadeRepository;
import com.project.snackfood.domain.repository.EstadoRepository;

public class CadastroCidadeService {

	@Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.buscar(estadoId);
        
        if (estado == null) {
            throw new EntidadeNaoEncotradaException(
                String.format("Não existe cadastro de estado com código %d", estadoId));
        }
        
        cidade.setEstado(estado);
        
        return cidadeRepository.salvar(cidade);
    }
    
    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.remover(cidadeId);
            
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncotradaException(
                String.format("Não existe um cadastro de cidade com código %d", cidadeId));
        
        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }
	
}
