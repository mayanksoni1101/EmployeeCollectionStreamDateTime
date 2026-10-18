package org.jsp.employeeDateTime;

import java.time.LocalDate;
import java.time.LocalTime;

public class Employee {

	String name;
	String company;
	double salary;
	LocalDate joining;
	LocalTime logIn;
	LocalTime logOut;
	
	public Employee(String name, String comapany, double salary, LocalDate d1 , LocalTime t1,LocalTime t2) {
		this.name = name;
		this.company = comapany;
		this.salary = salary;
		this.joining = d1;
		this.logIn = t1;
		this.logOut = t2;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", company=" + company + ", salary=" + salary + ", joining=" + joining
				+ ", logIn=" + logIn + ", logOut=" + logOut + "]";
	}

	
	
}
