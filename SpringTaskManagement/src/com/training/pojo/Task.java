package com.training.pojo;

import java.util.Date;

public class Task {

	private int id;
	private String taskName;

	private String dateTime;

	private String taskDescription;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", dateTime=" + dateTime + ", taskDescription="
				+ taskDescription + "]";
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String date) {
		this.dateTime = date;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

}
