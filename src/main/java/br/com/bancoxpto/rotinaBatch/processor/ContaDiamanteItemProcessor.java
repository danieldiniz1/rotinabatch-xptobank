package br.com.bancoxpto.rotinaBatch.processor;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import br.com.bancoxpto.rotinaBatch.model.TipoConta;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class ContaDiamanteItemProcessor implements ItemProcessor<Cliente, Conta> {
    @Override
    public Conta process(Cliente cliente) throws Exception {
        return Conta.builder()
                .cliente(cliente)
                .tipoConta(TipoConta.DIAMANTE)
                .Limite(BigDecimal.valueOf(5000.0))
                .build();
    }
}
