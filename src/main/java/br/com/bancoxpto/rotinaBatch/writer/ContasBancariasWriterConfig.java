package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContasBancariasWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public ItemWriter<Conta> contasBancariasWriter(){

        return items -> items.forEach(cliente -> LOGGER.info(cliente));
    }
}
