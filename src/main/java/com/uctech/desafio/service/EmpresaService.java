package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import com.uctech.desafio.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    final CnpjService cnpjService;


    public List<EmpresaModel> findAll(){
        List<EmpresaModel> empresas = empresaRepository.findAll();
        return empresas;
    }

    @Transactional
    public String saveEmpresa(String cnpj) {

        /*
        Fazer validação necessarias
         */

        EmpresaModel empresa = cnpjService.retornaEmpresa(cnpj);
        empresaRepository.save(empresa);
        return "Salvo com sucesos";
    }
}
