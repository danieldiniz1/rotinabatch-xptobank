package br.com.bancoxpto.rotinaBatch.processor;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import br.com.bancoxpto.rotinaBatch.model.TipoConta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

import java.util.HashMap;
import java.util.Map;

public class GeracaoContaClassifier implements Classifier<Cliente, ItemProcessor<?,? extends Conta>> {

    private static final Map<TipoConta,ItemProcessor<Cliente,Conta>> processadores = new HashMap<TipoConta,ItemProcessor<Cliente,Conta>>() {
        {
            put(TipoConta.PRATA, new ContaPrataItemProcessor());
            put(TipoConta.OURO, new ContaOuroItemProcessor());
            put(TipoConta.PLATINA, new ContaPlatinaItemProcessor());
            put(TipoConta.DIAMANTE, new ContaDiamanteItemProcessor());
        }
    };

    @Override
    public ItemProcessor<Cliente, Conta> classify(Cliente cliente) {
        return processadores.get(TipoConta.fromFaixaSalarial(cliente.getFaixaSalarial()));
    }
}
