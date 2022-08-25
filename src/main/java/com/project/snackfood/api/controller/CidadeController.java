package com.project.snackfood.api.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.snackfood.domain.exception.EntidadeEmUsoException;
import com.project.snackfood.domain.exception.EntidadeNaoEncotradaException;
import com.project.snackfood.domain.model.Cidade;
import com.project.snackfood.domain.repository.CidadeRepository;
import com.project.snackfood.domain.service.CadastroCidadeService;

public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;
	
    @Autowired
	private CadastroCidadeService cadastroCidade;
    
    @GetMapping("/{cidadeId}")
   	public ResponseEntity<Cidade> buscar(@PathVariable Long cidadeId) {
   		Cidade cidade = cidadeRepository.buscar(cidadeId);
   		
   		if (cidade != null) {
   			return ResponseEntity.ok(cidade);
   		}
   		
   		return ResponseEntity.notFound().build();
   	}
    
    @PostMapping
   	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
   		try {
   			cidade = cadastroCidade.salvar(cidade);
   			
   			return ResponseEntity.status(HttpStatus.CREATED)
   					.body(cidade);
   		} catch (EntidadeNaoEncotradaException e) {
   			return ResponseEntity.badRequest()
   					.body(e.getMessage());
   		}
   	}
    
    @PutMapping("/{cidadeAId}")
   	public ResponseEntity<Cidade> atualizar(@PathVariable Long cidadeId,
   			@RequestBody Cidade cidade) {
   		Cidade cidadeAtual = cidadeRepository.buscar(cidadeId);
   		
   		if (cidadeAtual != null) {
   			BeanUtils.copyProperties(cidade, cidadeAtual, "id");
   			
   			cidadeAtual = cadastroCidade.salvar(cidadeAtual);
   			return ResponseEntity.ok(cidadeAtual);
   		}
   		
   		return ResponseEntity.notFound().build();
   	}
    
    @DeleteMapping("/{cidadeAId}")
   	public ResponseEntity<?> remover(@PathVariable Long cidadeAId) {
   		try {
   			cadastroCidade.excluir(cidadeAId);	
   			return ResponseEntity.noContent().build();
   			
   		} catch (EntidadeNaoEncotradaException e) {
   			return ResponseEntity.notFound().build();
   			
   		} catch (EntidadeEmUsoException e) {
   			return ResponseEntity.status(HttpStatus.CONFLICT)
   					.body(e.getMessage());
   		}
   	}
       
}
