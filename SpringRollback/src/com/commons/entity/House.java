package com.commons.entity;

public class House {

	private int id;
	private String houseName;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return houseName;
	}
	@Override
	public String toString() {
		return "House [id=" + id + ", name=" + houseName + "]";
	}
	public void setName(String name) {
		this.houseName = name;
	}
}
