package br.com.bancoxpto.rotinaBatch.model;

import java.math.BigDecimal;

public enum TipoConta {

    PRATA,OURO,PLATINA,DIAMANTE;

    public static TipoConta fromFaixaSalarial(BigDecimal faixaSalarial){
        if (BigDecimal.valueOf(3000).compareTo(faixaSalarial) == 1)
            return PRATA;
        else if (BigDecimal.valueOf(5000).compareTo(faixaSalarial) == 1) {
            return OURO;
        }
        else if (BigDecimal.valueOf(1000).compareTo(faixaSalarial) == 1) {
            return OURO;
        }
        else
            return DIAMANTE;
    }
}
