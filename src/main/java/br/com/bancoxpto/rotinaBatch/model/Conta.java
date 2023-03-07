package br.com.bancoxpto.rotinaBatch.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Conta {

    private int id;
    private Enum<TipoConta> tipoConta;
    private BigDecimal Limite;
    private Cliente cliente;
}
