package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class CnpjService {
    public ResponseEntity<Object> retornaEmpresa(String cnpj) {

        try {
            EmpresaModel empresa = WebClient
                    .create("https://brasilapi.com.br/api/cnpj/v1/")
                    .get()
                    .uri("https://brasilapi.com.br/api/cnpj/v1/{cnpj}", cnpj)
                    .retrieve()
                    .bodyToMono(EmpresaModel.class).block();

            return ResponseEntity.ok(empresa);
        } catch (WebClientResponseException exception) {
            if (exception.getStatusCode() == HttpStatus.NOT_FOUND) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CEP não existente!");
            } else {
                return ResponseEntity.status(exception.getStatusCode()).body("Erro na requisição");
            }
        }
    }
}
