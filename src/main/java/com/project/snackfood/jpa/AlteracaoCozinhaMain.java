package com.project.snackfood.jpa;


import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.project.snackfood.SnackfoodApiApplication;
import com.project.snackfood.domain.model.Cozinha;
import com.project.snackfood.domain.repository.CozinhaRepository;

public class AlteracaoCozinhaMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(SnackfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		CozinhaRepository cozinhaRepository = applicationContext .getBean(CozinhaRepository.class);
		
		
		Cozinha cozinha1 = new Cozinha();
		cozinha1.setId(1L);
		cozinha1.setNome("Brasileira");
		
		cozinhaRepository.salvar(cozinha1);

	}
}
