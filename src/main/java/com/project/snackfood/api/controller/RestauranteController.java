package com.project.snackfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.snackfood.domain.exception.EntidadeNaoEncotradaException;
import com.project.snackfood.domain.model.Restaurante;
import com.project.snackfood.domain.repository.RestauranteRepository;
import com.project.snackfood.domain.service.CadastroRestauranteService;

@RestController // vai receber requições e retornar o corpo
@RequestMapping("/restaurantes")
public class RestauranteController {

		@Autowired
		private RestauranteRepository restauranteRepository;
		
		@Autowired 
		CadastroRestauranteService cadastroRestaurante;
		
		@GetMapping
		public List<Restaurante> listar(){
			return restauranteRepository.listar();
		}
		
		@GetMapping("/{restauranteId}") // criando uma variavel e vai receber no pathvarible
		public ResponseEntity<Restaurante>buscar(@PathVariable Long restauranteId) { // fazendo o buind
			Restaurante restaurante = restauranteRepository.buscar(restauranteId);
			if (restaurante != null) {
				return ResponseEntity.ok(restaurante);
			}
			
				return ResponseEntity.notFound().build();
		}
		
		@PostMapping
		public ResponseEntity<?> adicionar(@RequestBody Restaurante restaurante){
			try {
				restaurante = cadastroRestaurante.salvar(restaurante);
				
				return ResponseEntity.status(HttpStatus.CREATED)
						.body(restaurante);
			} catch (EntidadeNaoEncotradaException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
			}
			
		}
		
		
		
}
