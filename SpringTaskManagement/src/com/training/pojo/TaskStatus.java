package com.training.pojo;

public class TaskStatus {

	private int id;
	private String taskStatus;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	@Override
	public String toString() {
		return "TaskStatus [id=" + id + ", taskStatus=" + taskStatus + "]";
	}

}
