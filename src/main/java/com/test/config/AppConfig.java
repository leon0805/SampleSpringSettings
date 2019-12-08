package com.test.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
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
	
	@Bean
	public PlatformTransactionManager transationManager(@Autowired DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public PlatformTransactionManager transationManager2(@Autowired @Qualifier("dataSource2") DataSource dataSource)
	{
		return new DataSourceTransactionManager(dataSource);
	}

}
