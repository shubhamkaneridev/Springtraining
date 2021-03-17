package com.commons.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.commons.entity.Pincode;
import com.commons.entity.StreetMapper;

public class StreetJDBCTemplate implements StreetDAO {

	@Autowired
	private JdbcTemplate jdbcTemplateObject;

	@Autowired
	private DataSourceTransactionManager dataSourceTransactionManager;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate, DataSourceTransactionManager dataSourceTransactionManager) {
		this.jdbcTemplateObject = jdbcTemplate;
		this.dataSourceTransactionManager = dataSourceTransactionManager;
	}

	public List<Pincode> listhouses() {
		String SQL = "\r\n"
				+ "select  street.street_name,house.HOUSE_NAME,pincode.PINCODE from pincode,house,street where house.ID=street.HOUSE_ID and street.id=pincode.street_id;";
		List<Pincode> studentMarks = jdbcTemplateObject.query(SQL, new StreetMapper());

		return studentMarks;
	}

	@Override
	public void delete(Integer id) {

		String SQL1 = "delete from student where id = ?";
		String SQL2 = "delete from marks where sid = ?";

		jdbcTemplateObject.update(SQL2, id);
		jdbcTemplateObject.update(SQL1, id);
		System.out.println("Deleted Record with ID = " + id);
		return;

	}

	

	@Override
	public void create(String houseName, String streetName, int pincode) {

		TransactionDefinition def = new DefaultTransactionDefinition();
		TransactionStatus status = dataSourceTransactionManager.getTransaction(def);
		try {
			String SQL1 = "insert into house (HOUSE_NAME) values (?)";
			jdbcTemplateObject.update(SQL1, houseName);

			// Get the latest house id to be used in street table
			String SQL2 = "select max(id) from  house";
			Integer houseId = jdbcTemplateObject.queryForObject(SQL2, null, Integer.class);

			String SQL3 = "insert into street(STREET_NAME, HOUSE_ID) " + "values (?, ?)";
			jdbcTemplateObject.update(SQL3, streetName, houseId);

			// Get the latest street id to be used in pincode table
			String SQL4 = "select max(id) from  street";
			Integer streetId = jdbcTemplateObject.queryForObject(SQL4, null, Integer.class);

			String SQL5 = "insert into pincode(PINCODE, HOUSE_ID, STREET_ID) " + "values (?, ?,?)";
			jdbcTemplateObject.update(SQL5, "", houseId, streetId);

			System.out.println("Created recorded");
			dataSourceTransactionManager.commit(status);

			 //throw new RuntimeException("simulate Error condition");
		} catch (DataAccessException e) {
		

			System.out.println("Error in creating record, rolling back");
			throw e;
		}

	}

	@Override
	public void update(Integer houseId, String houseName, String streetName) {

		String SQL = " update street,house set street.STREET_NAME = ?,house.HOUSE_NAME=? where street.HOUSE_ID=house.id   and house.id=?";

		jdbcTemplateObject.update(SQL, streetName, houseName,houseId);
		System.out.println("Updated Record with ID = " + houseId);
	

	}

}