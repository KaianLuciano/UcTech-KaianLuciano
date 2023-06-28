package com.uctech.desafio.controller;

import com.uctech.desafio.model.EmpresaModel;
import com.uctech.desafio.service.CnpjService;
import com.uctech.desafio.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
@AllArgsConstructor
public class EmpresaController {

    final CnpjService cnpjService;

    final EmpresaService empresaService;

    //Método utilizado para testes
    @GetMapping("/consultar/api/{cnpj}")
    public ResponseEntity<EmpresaModel> consultarEmpresa(@PathVariable(value = "cnpj") String cnpj) {

        EmpresaModel empresa = cnpjService.retornaEmpresa(cnpj);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll());
    }

    @GetMapping("/{cnpj}")
    ResponseEntity<Object> findById(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findById(cnpj));
    }

    @GetMapping("/nome/{nomeFantasia}")
    ResponseEntity<Object> findEmpresaModelByNomeFantasia(@PathVariable(value = "nomeFantasia") String nomeFantasia) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findEmpresaModelByNomeFantasia(nomeFantasia));
    }

    @PostMapping("/{cnpj}")
    public ResponseEntity<Object> saveEmpresa(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.saveEmpresa(cnpj));
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Object> deleteById(@PathVariable String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.deleteEmpresa(cnpj));
    }

}
