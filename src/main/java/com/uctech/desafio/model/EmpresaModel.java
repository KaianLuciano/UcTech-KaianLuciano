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
    private String uf;

    private String razao_social;

    private String nome_fantasia;

    @Column(name = "data_inicio_atividade")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date data_inicio_atividade;

    private String natureza_juridica;

    @Column(name = "situacao_cadastral")
    @Enumerated(EnumType.STRING)
    private SituacaoCadastral situacao_cadastral;

    @Column(name = "data_situacao_cadastral")
    @DateTimeFormat(pattern = "dd/MM/yy")
    private Date data_situacao_cadastral;

    private String qualificacao_do_responsavel;

    private Long capital_social;

    private String porte;

    private boolean opcao_pelo_mei;

}
