package com.project.snackfood.infraestructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.project.snackfood.domain.model.Permisao;
import com.project.snackfood.domain.repository.PermisaoRepository;

@Component
public class PermisaoRepositoryImpl implements PermisaoRepository {
	
	@PersistenceContext
 	private EntityManager manager;
	
	public List<Permisao> listar(){
		return manager.createQuery("from Permisao", Permisao.class).
				getResultList();
	}
	@Override
	public Permisao buscar(Long Id) {
		return manager.find(Permisao.class, Id);
	}
	@Transactional
	@Override
	public Permisao salvar(Permisao permisao) {
		return manager.merge(permisao);
	}
	@Transactional
	@Override
	public void remover(Permisao permisao) {
		permisao = buscar(permisao.getId());
		manager.remove(permisao);
				
	}
	
	
}
