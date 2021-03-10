package com.training.jdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.training.dao.StudentDAO;
import com.training.mapper.CarMapper;
import com.training.mapper.StoreBasedMapper;
import com.training.mapper.StoreMapper;
import com.training.pojo.Car;
import com.training.pojo.Company;

import com.training.pojo.Store;

public class StudentJDBCTemplate implements StudentDAO {
	private DataSource dataSource;
	private SimpleJdbcCall jdbcCall;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	
	@Override
	public List<Store> listStudents() {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select  a.COMPANY_NAME, b.MODEL_NAME,  a.OWNER_NAME ,d.city_name ,e.country_name ,c.id\r\n"
				+ "from company a, car b, store c, city d,country e \r\n"
				+ "where a.ID=b.company_id and a.ID=c.Company_ID and c.country_id=e.id and c.city_id=d.id ;\r\n" + "";
		List<Store> students = jdbcTemplateObject.query(SQL, new StoreMapper());
		return students;
	}
	
	@Override
	public List<Car> getCarModel(Integer id) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select   b.MODEL_NAME    \r\n" + 
				"from company a, car b\r\n" + 
				"where a.ID=b.company_id  and a.id=?;";

		 List<Car> car = jdbcTemplateObject.query(SQL, new Object[] { id }, new CarMapper());

		return car;
	}

	@Override
	public List<Store> getStoreBaseInfo(int id) {
		JdbcTemplate jdbcTemplateObject = new JdbcTemplate(dataSource);
		String SQL = "select    d.city_name ,e.country_name ,c.id ,a.COMPANY_NAME\r\n" + 
				"from company a,  store c, city d,country e \r\n" + 
				"where   a.ID=c.Company_ID and c.country_id=e.id and c.city_id=d.id and a.id=?";

		 List<Store> store = jdbcTemplateObject.query(SQL, new Object[] { id }, new StoreBasedMapper());

		return store;
	}

}