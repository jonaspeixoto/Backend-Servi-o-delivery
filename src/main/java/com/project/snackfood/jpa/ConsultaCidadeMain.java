package com.project.snackfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.project.snackfood.SnackfoodApiApplication;
import com.project.snackfood.domain.model.Cidade;
import com.project.snackfood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {
	  
	public static void main(String[] args) {
          ApplicationContext applicationContext = new SpringApplicationBuilder(SnackfoodApiApplication.class)
                  .web(WebApplicationType.NONE)
                  .run(args);
          
          CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
          
          List<Cidade> todasCidades = cidadeRepository.listar();
          
          for (Cidade cidade : todasCidades) {
              System.out.printf("%s - %s\n", cidade.getNome(), cidade.getEstado().getNome());
          }
      }
}
