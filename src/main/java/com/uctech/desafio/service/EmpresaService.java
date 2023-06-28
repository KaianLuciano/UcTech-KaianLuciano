package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import com.uctech.desafio.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    final CnpjService cnpjService;


    public EmpresaModel findById(String cnpj) {

        /*
        Fazer validações com Optional como isPresent
         */

        String cnpjFormatado = cnpj.replaceAll("[\\.-]", "");

        Optional<EmpresaModel> empresaModel = empresaRepository.findById(cnpjFormatado);

        return empresaModel.get();
    }

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

    @Transactional
    public String deleteEmpresa(String cnpj) {

        /*
        Fazer validação necessarias
        Formatar o cnpj caso possua [. -] para deletar a empresa sem grandes problemas
         */

        String cnpjFormatado = cnpj.replaceAll("[\\.-]", "");

        empresaRepository.deleteById(cnpjFormatado);
        return "Produto Deletado!!";
    }
}
