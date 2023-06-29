package com.uctech.desafio.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.uctech.desafio.model.enums.SituacaoCadastral;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "tb_empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaModel implements Serializable {

    @Id
    private String cnpj;

    @Column(nullable = false, length = 2)
    private String uf;

    @Column(name = "razao_social")
    @JsonAlias("razao_social")
    private String razaoSocial;

    @Column(name = "nome_fantasia")
    @JsonAlias("nome_fantasia")
    private String nomeFantasia;

    @Column(name = "data_inicio_atividade")
    @JsonAlias("data_inicio_atividade")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private String dataInicioAtividade;

    @JsonAlias("natureza_juridica")
    private String naturezaJuridica;

    @Column(name = "situacao_cadastral")
    @JsonAlias("situacao_cadastral")
    @Enumerated(EnumType.STRING)
    private SituacaoCadastral situacaoCadastral;

    @Column(name = "data_situacao_cadastral")
    @JsonAlias("data_situacao_cadastral")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private String dataSituacaoCadastral;

    @Column(name = "qualificacao_do_responsavel")
    @JsonAlias("qualificacao_do_responsavel")
    private String qualificacaoDoResponsavel;

    @Column(name = "capital_social")
    @JsonAlias("capital_social")
    private Long capitalSocial;

    @Column(name = "porte_da_empresa")
    @JsonAlias("porte")
    private String porteDaEmpresa;

    @Column(name = "opcao_pelo_mei")
    @JsonAlias("opcao_pelo_mei")
    private boolean opcaoMei;

}
