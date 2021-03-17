package com.commons.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StreetMapper implements RowMapper<Pincode> {
	   public Pincode mapRow(ResultSet rs, int rowNum) throws SQLException {
		   
		   Street street= new Street();
		   House house=new House();
		   Pincode pincode=new  Pincode();
		   
		   house.setName(rs.getString("HOUSE_NAME"));
		   street.setStreetName(rs.getString("STREET_NAME"));
		   street.setHouse(house);
		   pincode.setHouse(house);
		   pincode.setStreet(street);
		   pincode.setCode(rs.getInt("PINCODE"));

	      return pincode;
	   }
	}


