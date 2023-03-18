package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class ClienteInvalidoWriterConfig {

    @Bean
    public FlatFileItemWriter<Conta> clienteInvalidoWriter(){
        return new FlatFileItemWriterBuilder<Conta>()
                .name("clienteInvalidoWriter")
                .resource(new FileSystemResource("./files/contas-invalidas.txt"))
                .delimited()
                .delimiter(";")
                .names("cliente")
                .build();
    }
}
