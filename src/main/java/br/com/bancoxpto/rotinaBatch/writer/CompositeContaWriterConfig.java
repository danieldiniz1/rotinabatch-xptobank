package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.support.builder.CompositeItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompositeContaWriterConfig {

    @Bean
    public CompositeItemWriter<Conta> compositeItemWriter(JdbcBatchItemWriter<Conta> contasBancariasWriter,
                                                          @Qualifier("fileContaWriter") FlatFileItemWriter<Conta> fileContaWriter){
        return new CompositeItemWriterBuilder<Conta>()
                .delegates(fileContaWriter,contasBancariasWriter)
                .build();
    }
}
