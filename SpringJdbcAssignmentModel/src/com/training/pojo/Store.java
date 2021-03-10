package com.training.pojo;

public class Store {

	private int id;
	private Country country;

	private Company company;
	private City city;

	private Car car;
	public int getId() {
		return id;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Store [id=" + id + ", country=" + country + ", company=" + company + ", city=" + city + ", car=" + car
				+ "]";
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
}