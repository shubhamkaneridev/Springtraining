package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.Car;
import com.training.pojo.Company;


public class CarMapper implements RowMapper<Car> {
	public Car mapRow(ResultSet rs, int rowNum) throws SQLException {

		Car car = new Car();

		Company company = new Company();
		car.setModelName(rs.getString("MODEL_NAME"));
		car.setCompany(company);
		return car;

	}
}