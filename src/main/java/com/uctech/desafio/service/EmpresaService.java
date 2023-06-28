package com.uctech.desafio.service;

import com.uctech.desafio.model.EmpresaModel;
import com.uctech.desafio.repository.EmpresaRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class EmpresaService {

    final EmpresaRepository empresaRepository;

    final CnpjService cnpjService;


    public ResponseEntity<Object> findById(String cnpj) {

        String cnpjFormatado = cnpj.replaceAll("[.-]", "");

        Optional<EmpresaModel> empresaModel = empresaRepository.findById(cnpjFormatado);

        if(empresaModel.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não possui uma empresa atrelada ao cnpj especificado");
        } else {
            return ResponseEntity.ok(empresaModel.get());
        }

    }

    public ResponseEntity<Object> findAll(){
        List<EmpresaModel> empresas = empresaRepository.findAll();

        if(empresas.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Lista de Empresas Vazia");
        } else {
            return ResponseEntity.ok(empresas);
        }

    }

    @Transactional
    public ResponseEntity<Object> saveEmpresa(String cnpj) {

        /*
        Fazer validação necessarias
         */

        EmpresaModel empresa = cnpjService.retornaEmpresa(cnpj);

        empresaRepository.save(empresa);
        return ResponseEntity.ok("Empresa salva com sucesos!");
    }

    @Transactional
    public ResponseEntity<Object> deleteEmpresa(String cnpj) {

        /*
        Fazer validação necessarias
        Formatar o cnpj caso possua [. -] para deletar a empresa sem grandes problemas
         */

        String cnpjFormatado = cnpj.replaceAll("[.-]", "");

        if(empresaRepository.findById(cnpjFormatado).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe empresa com o CNPJ inserido!");
        }

        empresaRepository.deleteById(cnpjFormatado);
        return ResponseEntity.ok("Empresa excluida");
    }
}
