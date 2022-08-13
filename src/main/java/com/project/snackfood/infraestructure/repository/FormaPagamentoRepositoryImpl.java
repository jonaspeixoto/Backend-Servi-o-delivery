package com.project.snackfood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.project.snackfood.domain.model.FormaPagamento;
import com.project.snackfood.domain.repository.FormaDePagamentoRepository;

@Component
public class FormaPagamentoRepositoryImpl implements FormaDePagamentoRepository {
	
	@PersistenceContext
 	private EntityManager manager;
	
	public List<FormaPagamento> listar(){
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).
				getResultList();
	}
	@Override
	public FormaPagamento buscar(Long Id) {
		return manager.find(FormaPagamento.class, Id);
	}
	@Transactional
	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}
	@Transactional
	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);
				
	}
	
	
}
