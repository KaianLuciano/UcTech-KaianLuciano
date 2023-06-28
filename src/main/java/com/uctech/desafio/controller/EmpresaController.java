package com.uctech.desafio.controller;

import com.uctech.desafio.model.EmpresaModel;
import com.uctech.desafio.service.CnpjService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empresas")
@AllArgsConstructor
public class EmpresaController {

    final CnpjService cnpjService;

    @GetMapping("/{cnpjEmpresa}")
    public ResponseEntity<ResponseEntity<EmpresaModel>> consultarEmpresa(@PathVariable(value = "cnpjEmpresa") String cnpj) {

        ResponseEntity<EmpresaModel> empresa = cnpjService.retornaEmpresa(cnpj);
        return ResponseEntity.ok(empresa);
    }
}
