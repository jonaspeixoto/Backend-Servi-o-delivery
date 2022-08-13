package com.project.snackfood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.project.snackfood.domain.model.Estado;
import com.project.snackfood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {
	
	@PersistenceContext
 	private EntityManager manager;
	
	public List<Estado> listar(){
		return manager.createQuery("from Estado", Estado.class).
				getResultList();
	}
	@Override
	public Estado buscar(Long Id) {
		return manager.find(Estado.class, Id);
	}
	@Transactional
	@Override
	public Estado salvar(Estado restaurante) {
		return manager.merge(restaurante);
	}
	@Transactional
	@Override
	public void remover(Estado restaurante) {
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);
				
	}
	
	
}
