package br.com.bancoxpto.rotinaBatch.writer;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import br.com.bancoxpto.rotinaBatch.model.Conta;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Configuration
public class ContasBancariasWriterConfig {

    private static final Logger LOGGER = LogManager.getLogger();

    @Bean
    public JdbcBatchItemWriter<Conta> contasBancariasWriter(@Qualifier("xptoBankDataSource") DataSource xptoBankDataSource){

        return new JdbcBatchItemWriterBuilder<Conta>()
                .dataSource(xptoBankDataSource)
                .sql("INSERT INTO conta (tipo, limite, cliente_id) VALUES (?,?,?)")
                .itemPreparedStatementSetter(itemPreparedStatementSetter())
                .build();
    }

    private ItemPreparedStatementSetter<Conta> itemPreparedStatementSetter() {
        return new ItemPreparedStatementSetter<Conta>() {
            @Override
            public void setValues(Conta conta, PreparedStatement ps) throws SQLException {
                ps.setString(1,conta.getTipoConta().name());
                ps.setBigDecimal(2,conta.getLimite());
                ps.setString(3,conta.getCliente().getEmail());
            }
        };
    }
}
