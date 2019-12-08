package com.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@ComponentScan(basePackages = "com.test.config")
public class AppConfig {

	@Bean
	public JdbcTemplate jdbcTemplate(@Autowired DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate2(@Autowired @Qualifier("dataSource2") DataSource dataSource)
	{
		return new JdbcTemplate(dataSource);
	}

}
