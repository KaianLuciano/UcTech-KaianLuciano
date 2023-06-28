package com.uctech.desafio.model;

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

    @Column(nullable = false, unique = true, length = 2)
    private char uf;

    @Column(name = "nome_empresa")
    private String nomeEmpresa;

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "data_inicio_atividade")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date dataInicioAtividade;

    private String naturezaJuridica;

    @Column(name = "situacao_cadastral")
    @Enumerated(EnumType.STRING)
    private SituacaoCadastral situacaoCadastral;

    @Column(name = "data_situacao_cadastral")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date dataSituacaoCadastral;

    @Column(name = "qualificacao_do_responsavel")
    private String qualificacaoDoResponsavel;

    @Column(name = "capital_social")
    private Long capitalSocial;

    @Column(name = "porte_da_empresa")
    private String porteDaEmpresa;

    @Column(name = "opcao_mei")
    private boolean opcaoMei;

}
