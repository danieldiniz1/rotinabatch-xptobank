package br.com.bancoxpto.rotinaBatch.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cliente {

    private String nome;
    private int idade;
    private String email;
    private BigDecimal faixaSalarial;
}
