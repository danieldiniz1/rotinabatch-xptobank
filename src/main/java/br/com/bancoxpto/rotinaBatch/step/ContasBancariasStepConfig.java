package br.com.bancoxpto.rotinaBatch.step;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class ContasBancariasStepConfig {

    @Bean
    public Step contasBancariasStep(ItemReader<Cliente> contasBancariasReader,
                                    ItemProcessor<Cliente, Conta> contasBancariasProcessor,
                                    ItemWriter<Conta> contasBancariasWriter,
                                    JobRepository jobRepository,
                                    PlatformTransactionManager transactionManager){
        return new StepBuilder("contasBancariasStep",jobRepository)
                .<Cliente,Conta> chunk(100)
                .reader(contasBancariasReader)
                .processor(contasBancariasProcessor)
                .writer(contasBancariasWriter)
                .faultTolerant()
                .skip(Exception.class)
                .skipLimit(2)
                .transactionManager(transactionManager)
                .build();
    }
}
