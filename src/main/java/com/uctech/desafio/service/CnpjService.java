package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CnpjService {

    //https://brasilapi.com.br/api/cnpj/v1/15.684.307/0001-26
    public ResponseEntity<EmpresaModel> retornaEmpresa(String cnpj) {

        String cnpjSemPontuacao = cnpj.replaceAll("[./-]", "");

        String url = "https://brasilapi.com.br/api/cnpj/v1/" + cnpjSemPontuacao;

        RestTemplate restTemplate = new RestTemplate();

        System.out.println("-URL Consultada: " + url);
        ResponseEntity<EmpresaModel> empresa = restTemplate.getForEntity(url, EmpresaModel.class);

        return empresa;
    }
}
