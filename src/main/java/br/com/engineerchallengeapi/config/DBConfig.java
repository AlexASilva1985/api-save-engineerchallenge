package br.com.engineerchallengeapi.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class DBConfig {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "app.datasource.postgresql")
    public DataSource dataSourcePostgresSql() {
        return DataSourceBuilder.create().build();
    }

    @Bean
    public JdbcTemplate jdbcTemplatePostgresSql(@Qualifier("dataSourcePostgresSql") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
