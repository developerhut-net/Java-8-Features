package com.developerhut.net;

public class Employee {

	private String name;
	private boolean active;
	private int salary;
	private String dept;

	public Employee(String name, boolean active, int salary, String dept) {
		super();
		this.name = name;
		this.active = active;
		this.salary = salary;
		this.dept = dept;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", active=" + active + ", salary=" + salary + "]";
	}

}
