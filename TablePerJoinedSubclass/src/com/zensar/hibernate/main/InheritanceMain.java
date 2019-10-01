package com.zensar.hibernate.main;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Employee;
import com.zensar.entities.WageEmp;

public class InheritanceMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		Employee e=new Employee();
		e.setName("Riya");
		e.setJoiningDate(LocalDate.of(2019, 8, 26));
		e.setSalary(30000);
		s.save(e);
		
		
		WageEmp we=new WageEmp();
		we.setName("John");
		we.setJoiningDate(LocalDate.of(2019, 6, 17));
		we.setSalary(40000);
		we.setHours(10);
		we.setRate(500.0f);
		s.save(we);
		
		
		
		
		t.commit();
		s.close();
		
	}

}

/*
mysql> select * from emp_master_2;
+------------+-------------+------+--------+
| employeeId | joiningDate | name | salary |
+------------+-------------+------+--------+
|         13 | 2019-08-26  | Riya |  30000 |
|         14 | 2019-06-17  | John |  40000 |
+------------+-------------+------+--------+
2 rows in set (0.00 sec)

mysql> select * from wageemp_2;
+-------+------+------------+
| hours | rate | employeeId |
+-------+------+------------+
|    10 |  500 |         14 |
+-------+------+------------+
1 row in set (0.00 sec)
 */
