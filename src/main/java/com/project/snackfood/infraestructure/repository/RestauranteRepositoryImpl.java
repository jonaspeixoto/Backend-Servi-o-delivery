package com.project.snackfood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.project.snackfood.domain.model.Restaurante;
import com.project.snackfood.domain.repository.RestauranteRepository;

public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
 	private EntityManager manager;
	
	public List<Restaurante> listar(){
		return manager.createQuery("from Restaurante", Restaurante.class).
				getResultList();
	}
	@Override
	public Restaurante buscar(Long Id) {
		return manager.find(Restaurante.class, Id);
	}
	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}
	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);
				
	}
	
	
}
