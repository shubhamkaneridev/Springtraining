package com.commons.entity;

public class Street {

	private int id;
	private String streetName;
	private House house;
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Street [id=" + id + ", streetName=" + streetName + ", house=" + house + "]";
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
}
