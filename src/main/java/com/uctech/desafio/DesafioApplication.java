package com.uctech.desafio;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "UcTech", version = "1", description = "API Desenvolvida para o Gerenciamento de Dados recebidos"))
@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}

	// Url usada para testes: https://brasilapi.com.br/api/cnpj/v1/15.684.307000126
	// Url para acessar Documentação: http://localhost:8080/swagger-ui/index.html#/
}
