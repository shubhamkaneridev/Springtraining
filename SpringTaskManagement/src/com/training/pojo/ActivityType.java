package com.training.pojo;

import java.util.Date;

public class ActivityType {


	
	@Override
	public String toString() {
		return "activityType [id=" + id + ", activityType=" + activityType + "]";
	}

	private int id;
	
	private String activityType;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}
	
}
