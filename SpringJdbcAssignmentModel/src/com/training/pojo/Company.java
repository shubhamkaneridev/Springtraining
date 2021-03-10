package com.training.pojo;

public class Company {

	private int id;
	private String companyName;
	private String ownerName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", companyName=" + companyName + ", ownerName=" + ownerName + "]";
	}

}
