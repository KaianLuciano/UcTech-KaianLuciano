package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CnpjService {

    //https://brasilapi.com.br/api/cnpj/v1/15.684.307/0001-26
    public EmpresaModel retornaEmpresa(String cnpj) {

        String cnpjSemPontuacao = cnpj.replaceAll("[./-]", "");

        String url = "https://brasilapi.com.br/api/cnpj/v1/";
        String uri = "https://brasilapi.com.br/api/cnpj/v1/{cnpj}";

        EmpresaModel empresa = WebClient
                .create(url)
                .get()
                .uri(uri, cnpj)
                .retrieve()
                .bodyToMono(EmpresaModel.class).block();

        return empresa;
    }
}
