package com.model;

import java.math.BigDecimal;

public class Coupon {

	
	
	
	
	@Override
	public String toString() {
		return "<h2>Coupon data</h2> Coupon  id:" + id + "<br> code:" + code + "<br> discount:" + discount + "<br> expDate:" + expDate + "";
	}

	private int id;
	private String code;
	private BigDecimal discount;
	
	private String expDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
}
