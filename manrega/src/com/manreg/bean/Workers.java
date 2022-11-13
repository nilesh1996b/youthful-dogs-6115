package com.manreg.bean;

public class Workers {
	private int empId;
	private String name; 
	private int salary;
	private String email; 
	private String dateOfJoin;
	public Workers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Workers(int empId, String name, int salary, String email, String dateOfJoin) {
		super();
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.email = email;
		this.dateOfJoin = dateOfJoin;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfJoin() {
		return dateOfJoin;
	}
	public void setDateOfJoin(String dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}
	@Override
	public String toString() {
		return "Workers [empId=" + empId + ", name=" + name + ", salary=" + salary + ", email=" + email
				+ ", dateOfJoin=" + dateOfJoin + "]";
	}
	
	
}
