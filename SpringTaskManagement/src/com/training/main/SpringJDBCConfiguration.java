package com.training.main;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.training.dao.TaskDAO;
import com.training.jdbcTemplate.ExamJDBCTemplate;

@Configuration
public class SpringJDBCConfiguration {
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/taskmanagement");// change url
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
	public TaskDAO taskDAO() {
		ExamJDBCTemplate exam = new ExamJDBCTemplate();

		//exam.setJdbcTemplate(jdbcTemplate());

		return exam;
	}

}