package com.training.pojo;

public class Users {

	private int id;
	private String userName;
	private int age;

	private TaskLocation taskLocation;
	private ActivityType activityType;
	private TaskStatus taskStatus;
	private Task task;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public TaskLocation getTaskLocation() {
		return taskLocation;
	}

	public void setTaskLocation(TaskLocation taskLocation) {
		this.taskLocation = taskLocation;
	}

	public ActivityType getActivityType() {
		return activityType;
	}

	public void setActivityType(ActivityType activityType) {
		this.activityType = activityType;
	}

	public TaskStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(TaskStatus taskStatus) {
		this.taskStatus = taskStatus;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", age=" + age + ", taskLocation=" + taskLocation
				+ ", activityType=" + activityType + ", taskStatus=" + taskStatus + ", task=" + task + "]";
	}

}
