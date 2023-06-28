package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class CnpjService {

    public EmpresaModel retornaEmpresa(String cnpj) {

        /*
        Fazer validação do tamanho do cnpj
        Fazer validação se existe o cnpj passado
        Fazer validação se o cnpj passado possui letras
         */

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
