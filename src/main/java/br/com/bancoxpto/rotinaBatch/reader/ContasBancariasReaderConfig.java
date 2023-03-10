package br.com.bancoxpto.rotinaBatch.reader;

import br.com.bancoxpto.rotinaBatch.model.Cliente;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.PagingQueryProvider;
import org.springframework.batch.item.database.builder.JdbcPagingItemReaderBuilder;
import org.springframework.batch.item.database.builder.JpaPagingItemReaderBuilder;
import org.springframework.batch.item.database.support.SqlPagingQueryProviderFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Configuration
public class ContasBancariasReaderConfig {

    @Bean
    public ItemReader<Cliente> contasBancariasReader(@Qualifier("xptoBankDataSource") DataSource dataSource,
                                                     PagingQueryProvider queryProvider){
        return new JdbcPagingItemReaderBuilder<Cliente>()
                .name("contasBancariasReader")
                .dataSource(dataSource)
                .queryProvider(queryProvider)
                .pageSize(1)
                .rowMapper(new BeanPropertyRowMapper<>(Cliente.class))
                .build();
    }

    @Bean
    public SqlPagingQueryProviderFactoryBean queryProvider(@Qualifier("xptoBankDataSource") DataSource dataSource){
        SqlPagingQueryProviderFactoryBean queryProvider = new SqlPagingQueryProviderFactoryBean();
        queryProvider.setDataSource(dataSource);
        queryProvider.setSelectClause("SELECT *");
        queryProvider.setFromClause("FROM cliente");
        queryProvider.setSortKey("email");
        return queryProvider;
    }
}
