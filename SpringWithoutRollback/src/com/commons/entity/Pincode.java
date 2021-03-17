package com.commons.entity;

public class Pincode {

	private int id;
	private int code;
	private House house;
	@Override
	public String toString() {
		return "Pincode [id=" + id + ", code=" + code + ", house=" + house + ", street=" + street + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public House getHouse() {
		return house;
	}
	public void setHouse(House house) {
		this.house = house;
	}
	public Street getStreet() {
		return street;
	}
	public void setStreet(Street street) {
		this.street = street;
	}
	private Street street;
}
