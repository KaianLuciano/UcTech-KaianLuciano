package com.uctech.desafio.controller;

import com.uctech.desafio.service.CnpjService;
import com.uctech.desafio.service.EmpresaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
@Tag(name = "Empresa")
@AllArgsConstructor
public class EmpresaController {

    final CnpjService cnpjService;

    final EmpresaService empresaService;

    @Operation(summary = "Irá buscar todas as empresas contidas no banco")
    @GetMapping
    public ResponseEntity<Object> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findAll());
    }

    @Operation(summary = "Retorna o carrinho que representa o CNPJ fornecido")
    @GetMapping("/{cnpj}")
    ResponseEntity<Object> findById(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findById(cnpj));
    }

    @Operation(summary = "Retorna a empresa que representa a RazãoSocial")
    @GetMapping("/nome/{razaoSocial}")
    ResponseEntity<Object> findEmpresaModelByRazaoSocial(@PathVariable(value = "razaoSocial") String razaoSocial) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.findEmpresaModelByRazaoSocial(razaoSocial));
    }

    @Operation(summary = "Salva a empresa no banco que representa o CNPJ fornecido, sendo o mesmo consultando em uma API publica")
    @PostMapping("/{cnpj}")
    public ResponseEntity<Object> saveEmpresa(@PathVariable(value = "cnpj") String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.saveEmpresa(cnpj));
    }

    @Operation(summary = "Deleta a empresa representada pelo CNPJ usada para Testes")
    @DeleteMapping("/{cnpj}")
    public ResponseEntity<Object> deleteById(@PathVariable String cnpj) {
        return ResponseEntity.status(HttpStatus.OK).body(empresaService.deleteEmpresa(cnpj));
    }

}
