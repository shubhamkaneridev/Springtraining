package com.training.dao;

import java.util.List;

import javax.sql.DataSource;

import com.training.pojo.Car;
import com.training.pojo.Company;
import com.training.pojo.Store;

public interface StudentDAO {

	public List<Store> listStudents();

	public List<Car> getCarModel(Integer id);

	public List<Store> getStoreBaseInfo(int id);

}