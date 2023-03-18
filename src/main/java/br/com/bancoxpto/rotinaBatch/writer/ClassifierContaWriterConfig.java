package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Conta;
import br.com.bancoxpto.rotinaBatch.model.TipoConta;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.ClassifierCompositeItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.ClassifierCompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassifierContaWriterConfig {

    @Bean
    public ClassifierCompositeItemWriter<Conta> classifierCompositeWriter(
            @Qualifier("clienteInvalidoWriter") FlatFileItemWriter<Conta> clienteInvalidoWriter,
            CompositeItemWriter<Conta> compositeItemWriter){
        return new ClassifierCompositeItemWriterBuilder<Conta>()
                .classifier(classifier(clienteInvalidoWriter,compositeItemWriter))
                .build();
    }

    private Classifier<Conta, ItemWriter<? super Conta>> classifier(FlatFileItemWriter<Conta> clienteInvalidoWriter, CompositeItemWriter<Conta> compositeItemWriter) {
        return new Classifier<Conta, ItemWriter<? super Conta>>() {
            @Override
            public ItemWriter<? super Conta> classify(Conta conta) {
                if (conta.getTipoConta().equals(TipoConta.INVALIDA))
                    return clienteInvalidoWriter;
                return compositeItemWriter;
            }
        };
    }


}
