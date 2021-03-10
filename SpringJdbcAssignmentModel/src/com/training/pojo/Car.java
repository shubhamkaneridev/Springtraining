package com.training.pojo;

public class Car {

	private int id;
	
	private String modelName;
	@Override
	public String toString() {
		return "Car [id=" + id + ", modelName=" + modelName + ", company=" + company + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	private Company company;
	
	
	
	
}
