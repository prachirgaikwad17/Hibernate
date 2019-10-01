package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Country;
import com.zensar.entities.Flag;

public class OneToOneMappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		Country c1=new Country();
		c1.setName("India");
		c1.setLanguage("Hindi");
		c1.setPopulation(100000l);
		
		
		Flag f1=new Flag();
		f1.setFlagName("Tiranga");
		f1.setDescription("It is tricolor flag");
		
		c1.setFlag(f1);
		f1.setCountry(c1);
		
		s.save(f1);
		s.save(c1);
		
		
		t.commit();
		s.close();
	
		System.exit(0);
		
	}

}

/*
  mysql> select * from Country;
+-----------+----------+---------+------------+-------------+
| countryId | language | name    | population | flag_flagId |
+-----------+----------+---------+------------+-------------+
|        16 | German   | Germany |     100000 |          15 |
+-----------+----------+---------+------------+-------------+
1 row in set (0.00 sec)

mysql> select * from Flag;
+--------+---------------------+----------+-------------------+
| flagId | description         | flagName | country_countryId |
+--------+---------------------+----------+-------------------+
|     15 | It is tricolor flag | Tricolor |                16 |
+--------+---------------------+----------+-------------------+
1 row in set (0.00 sec)


FK:
mysql> select * from Country;
+-----------+----------+-------+------------+---------+
| countryId | language | name  | population | flag_id |
+-----------+----------+-------+------------+---------+
|         2 | Hindi    | India |     100000 |       1 |
+-----------+----------+-------+------------+---------+
1 row in set (0.00 sec)

mysql> select * from Flag;
+--------+---------------------+----------+-------------------+
| flagId | description         | flagName | country_countryId |
+--------+---------------------+----------+-------------------+
|      1 | It is tricolor flag | Tiranga  |                 2 |
+--------+---------------------+----------+-------------------+
1 row in set (0.00 sec)







mysql> select * from Country;   (Parent table)
+-----------+----------+-------+------------+
| countryId(PK) | language | name  | population |
+-----------+----------+-------+------------+
|         2 | Hindi    | India |     100000 |
+-----------+----------+-------+------------+
1 row in set (0.00 sec)

mysql> select * from Flag;   (Child table)
+--------+---------------------+----------+------------+
| flagId (PK)| description         | flagName | country_id(FK) |
+--------+---------------------+----------+------------+
|      1 | It is tricolor flag | Tiranga  |          2 |
+--------+---------------------+----------+------------+
1 row in set (0.00 sec)







mysql> select * from Flag;  (Parent table)
+--------+---------------------+----------+
| flagId(PK) | description         | flagName |
+--------+---------------------+----------+
|      1 | It is tricolor flag | Tiranga  |
+--------+---------------------+----------+
1 row in set (0.00 sec)

mysql> select * from Country;   (Child table)
+-----------+----------+-------+------------+---------+
| countryId(PK) | language | name  | population | flag_id(FK) |
+-----------+----------+-------+------------+---------+
|         2 | Hindi    | India |     100000 |       1 |
+-----------+----------+-------+------------+---------+
1 row in set (0.00 sec)




*/