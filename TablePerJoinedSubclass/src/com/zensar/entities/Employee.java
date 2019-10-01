package com.zensar.entities;

import java.time.LocalDate;

//import javax.persistence.DiscriminatorColumn;
//import javax.persistence.DiscriminatorType;
//import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author Prachi Gaikwad
 * @creation_date 27th Sep 2019 11.30am
 * @modification_date 27th Sep 2019 2.44pm
 * @version 2.0
 * @copyright Zensar Technologies.All rights reserved.
 * @description It is a persistent class.
 * 				It is POJO class.
 *
 */


@Entity
@Table(name = "emp_master_2")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.AUTO )
	private int employeeId;
	private String name;
	private LocalDate joiningDate;
	private double salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int employeeId, String name, LocalDate joiningDate, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.joiningDate = joiningDate;
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(LocalDate joiningDate) {
		this.joiningDate = joiningDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", joiningDate=" + joiningDate + ", salary="
				+ salary + "]";
	}
	
	
	
}
