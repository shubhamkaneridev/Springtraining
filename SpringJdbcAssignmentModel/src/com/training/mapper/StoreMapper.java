package com.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.training.pojo.Car;
import com.training.pojo.City;
import com.training.pojo.Company;
import com.training.pojo.Country;
import com.training.pojo.Store;

public class StoreMapper implements RowMapper<Store> {
	public Store mapRow(ResultSet rs, int rowNum) throws SQLException {

		City city = new City();
		Country country = new Country();
		Store store = new Store();
		Company company = new Company();
		Car car = new Car();

		city.setCityName(rs.getString("city_name"));
		company.setCompanyName(rs.getString("COMPANY_NAME"));
		company.setOwnerName(rs.getString("OWNER_NAME"));
		car.setModelName(rs.getString("MODEL_NAME"));
		country.setCountryName(rs.getString("country_name"));
		store.setId(rs.getInt("id"));

		store.setCity(city);
		store.setCompany(company);
		store.setCountry(country);
		store.setCar(car);
		return store;

	}
}