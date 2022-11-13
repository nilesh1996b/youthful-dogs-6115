package com.manreg.bean;

public class WorkType {

	private int workId;
	private String workName;
	private int workHours;
	WorkType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public WorkType(int workId, String workName, int workHours) {
		super();
		this.workName = workName;
		this.workHours = workHours;
	}
	
	public WorkType(String workName, int workHours) {
		super();
		this.workName = workName;
		this.workHours = workHours;
	}
	public int getWorkId() {
		return workId;
	}
	public void setWorkId(int workId) {
		this.workId = workId;
	}
	public String getWorkName() {
		return workName;
	}
	public void setWorkName(String workName) {
		this.workName = workName;
	}
	public int getWorkHours() {
		return workHours;
	}
	public void setWorkHours(int workHours) {
		this.workHours = workHours;
	}
	@Override
	public String toString() {
		return "WorkType [workId=" + workId + ", workName=" + workName + ", workHours=" + workHours + "]";
	}
	
	
	
}
