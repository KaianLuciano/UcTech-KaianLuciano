package com.uctech.desafio.repository;

import com.uctech.desafio.model.EmpresaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<EmpresaModel, String> {

    EmpresaModel findEmpresaModelByRazaoSocial(String razaoSocial);

}
