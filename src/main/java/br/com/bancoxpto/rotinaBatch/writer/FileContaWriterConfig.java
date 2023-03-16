package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;

@Configuration
public class FileContaWriterConfig {

    @Bean
    public FlatFileItemWriter<Conta> fileContaWriter(){
        return new FlatFileItemWriterBuilder<Conta>()
                .name("fileContaWriter")
                .resource(new FileSystemResource("./files/contas.txt"))
                .delimited()
                .names("tipoConta","limite","cliente")
                .build();
    }
}