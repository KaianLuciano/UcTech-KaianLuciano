package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClient;

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
        } catch (HttpClientErrorException.NotFound ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Recurso não encontrado");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao chamar a API");
        }

    }
}
