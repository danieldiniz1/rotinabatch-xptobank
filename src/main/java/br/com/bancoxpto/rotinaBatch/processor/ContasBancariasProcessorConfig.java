package br.com.bancoxpto.rotinaBatch.processor;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.ClassifierCompositeItemProcessor;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemProcessorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContasBancariasProcessorConfig {

    @Bean
    public ItemProcessor<Cliente, Conta> contasBancariasProcessor(){

        return new ClassifierCompositeItemProcessorBuilder<Cliente,Conta>()
                .classifier(new GeracaoContaClassifier())
                .build();
    }

}
