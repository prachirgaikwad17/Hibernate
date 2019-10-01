package com.zensar.entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Prachi Gaikwad
 * @creation_date 27th Sep 2019 11.48am
 * @modification_date 25th Sep 2019 11.48am
 * @version 1.0
 * @copyright Zensar Technologies.All rights reserved.
 * @description It is a Entity class.
 *
 */

@Entity
@DiscriminatorValue("b")
public class WageEmp extends Employee {
	private int hours;
	private float rate;
	
	public WageEmp() {
		// TODO Auto-generated constructor stub
	}

	public WageEmp(int employeeId, String name, LocalDate joiningDate, double salary, int hours, float rate) {
		super(employeeId, name, joiningDate, salary);
		this.hours = hours;
		this.rate = rate;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "WageEmp [hours=" + hours + ", rate=" + rate + "]";
	}
	
	
	
}
