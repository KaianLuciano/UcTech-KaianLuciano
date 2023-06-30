package com.uctech.desafio.model.enums;


public enum SituacaoCadastral {

    NULA(1),
    ATIVA(2),
    SUSPENSA(3),
    INAPTA(4),
    ATIVA_NAO_REGULAR(5),
    BAIXADA(8);

    private int value;

    SituacaoCadastral(int value) {
        this.value = value;
    }

}
