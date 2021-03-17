package com.commons.dao;

import java.util.List;

import com.commons.entity.Pincode;


public interface StreetDAO {
	

	
	public void create(String houseName, String streetName, int pincode);

	
	public List<Pincode> listhouses();

	public void delete(Integer id);

	public void update(Integer houseId, String houseName, String streetName);




}