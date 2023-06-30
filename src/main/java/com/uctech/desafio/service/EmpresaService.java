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
        Optional<EmpresaModel> empresaModel = empresaRepository.findById(cnpj);
        return empresaModel.isEmpty() ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não possui uma empresa atrelada ao cnpj especificado") : ResponseEntity.ok(empresaModel.get());
    }

    public ResponseEntity<Object> findEmpresaModelByRazaoSocial(String razaoSocial) {
            EmpresaModel empresa = empresaRepository.findEmpresaModelByRazaoSocial(razaoSocial);
            return empresa == null ? ResponseEntity.status(HttpStatus.NOT_FOUND).body("Empresa não encontrada!") : ResponseEntity.ok(empresa);
    }

    public ResponseEntity<Object> findAll(){
        List<EmpresaModel> empresas = empresaRepository.findAll();
        return empresas.isEmpty() ? ResponseEntity.status(HttpStatus.NO_CONTENT).body("Lista de Empresas Vazia") : ResponseEntity.ok(empresas);
    }

    @Transactional
    public ResponseEntity<Object> saveEmpresa(String cnpj) {
        if(empresaRepository.findById(cnpj).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma empresa com o CNPJ fornecido!");
        }

        ResponseEntity<Object> empresaResponse = cnpjService.retornaEmpresa(cnpj);

        if (empresaResponse.getStatusCode().value() == HttpStatus.OK.value()) {
            EmpresaModel empresa = (EmpresaModel) empresaResponse.getBody();
            empresaRepository.save(empresa);
            return ResponseEntity.ok("Empresa salva com sucesos!");
        } else {
            return empresaResponse;
        }

    }

    @Transactional
    public ResponseEntity<Object> deleteEmpresa(String cnpj) {
        String cnpjFormatado = cnpj.replaceAll("[.-]", "");

        if(empresaRepository.findById(cnpjFormatado).isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não existe empresa com o CNPJ inserido!");
        }

        empresaRepository.deleteById(cnpjFormatado);
        return ResponseEntity.ok("Empresa excluida");
    }
}
