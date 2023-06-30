package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CnpjService {
    public EmpresaModel retornaEmpresa(String cnpj) {

        return  WebClient
                .create("https://brasilapi.com.br/api/cnpj/v1/")
                .get()
                .uri("https://brasilapi.com.br/api/cnpj/v1/{cnpj}", cnpj)
                .retrieve()
                .bodyToMono(EmpresaModel.class).block();

    }
}
