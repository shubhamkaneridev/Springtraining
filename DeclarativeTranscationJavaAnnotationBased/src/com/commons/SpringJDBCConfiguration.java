package com.commons;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.commons.dao.StudentDAO;
import com.commons.dao.StudentJDBCTemplate;


@Configuration
public class SpringJDBCConfiguration {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/studentspring");// change url
		dataSource.setUsername("root");// change userid
		dataSource.setPassword("root");// change pwd

		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

	@Bean
	public StudentDAO studentDAO() {

		StudentJDBCTemplate studentJDBCTemplate = new StudentJDBCTemplate();



		return studentJDBCTemplate;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {

		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());

		return dataSourceTransactionManager;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}