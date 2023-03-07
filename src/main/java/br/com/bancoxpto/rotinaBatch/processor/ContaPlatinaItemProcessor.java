package br.com.bancoxpto.rotinaBatch.processor;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import br.com.bancoxpto.rotinaBatch.model.TipoConta;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

public class ContaPlatinaItemProcessor implements ItemProcessor<Cliente, Conta> {
    @Override
    public Conta process(Cliente cliente) throws Exception {
        return Conta.builder()
                .cliente(cliente)
                .tipoConta(TipoConta.PLATINA)
                .Limite(BigDecimal.valueOf(2500.0))
                .build();
    }
}
