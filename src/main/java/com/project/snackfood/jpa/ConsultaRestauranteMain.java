package com.project.snackfood.jpa;


import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.project.snackfood.SnackfoodApiApplication;
import com.project.snackfood.domain.model.Restaurante;
import com.project.snackfood.domain.repository.CozinhaRepository;
import com.project.snackfood.domain.repository.RestauranteRepository;

public class ConsultaRestauranteMain {
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(SnackfoodApiApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
				
		RestauranteRepository restaRepository = applicationContext .getBean(RestauranteRepository.class);
//		
//		List<Restaurante> restaurantes = restaRepository.listar();
//		
//		for(Restaurante restaurante: restaurantes ) {
////			System.out.printf("%s > %f > %s",restaurante.getNome(),
////					restaurante.getTaxaFrete(), restaurante.getCozinha().getNome());
//			
//		}
	}
}
