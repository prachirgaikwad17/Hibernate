package com.zensar.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class DbOperations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration c=new Configuration().configure();
		//singleton and heavy weight SessionFactory
		SessionFactory f=c.buildSessionFactory();
		//represents database connection and light weight
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		//Product p=new Product(1008,"PC","Dell",40000);
		//	s.save(p);
		
		//get record according to primary key
		/*Product p=s.get(Product.class,1009);
		if(p==null)
		{
			System.out.println("Sorry! Product not found.");
		}
		else
		{
			System.out.println(p);
		}*/
		
		
		
		//Product p=s.load(Product.class,1004);
		//System.out.println(p);

		//update a record
		/*Product p=s.get(Product.class,1004);
		if(p!=null)
		{
			p.getPrice();
			p.setPrice(p.getPrice()+2);
			s.update(p);
			System.out.println(p);
		}
		else
		{
			System.out.println("Sorry! Product not found.");
		}*/
		
		
		//delete 
		Product p=s.get(Product.class,1002);
		if(p!=null)
		{
			
			s.delete(p);
			System.out.println(p);
		}
		else
		{
			System.out.println("Sorry! Product not found.");
		}
		
		
		
		
				t.commit();   //in dml operations
				s.close();
		
		
	}

}



/*output :
Hibernate: select max(id) from product1
Hibernate: insert into product1 (name, brand, price, id) values (?, ?, ?, ?)

mysql> select * from product1;
+------+--------+---------+-------+
| id   | name   | brand   | price |
+------+--------+---------+-------+
| 1001 | LED TV | Sony    | 45000 |
| 1002 | Laptop | HP      | 39800 |
| 1003 | Mobile | Samsung | 19900 |
+------+--------+---------+-------+
3 rows in set (0.00 sec)

mysql> select * from product1;
+------+---------+---------+-------+
| id   | name    | brand   | price |
+------+---------+---------+-------+
| 1001 | LED TV  | Sony    | 45000 |
| 1002 | Laptop  | HP      | 39800 |
| 1003 | Mobile  | Samsung | 19900 |
| 1004 | Speaker | Boat    |  1000 |
+------+---------+---------+-------+
4 rows in set (0.00 sec)



//update-increment price by 2
mysql> select * from product1;
+------+---------+---------+-------+
| id   | name    | brand   | price |
+------+---------+---------+-------+
| 1001 | LED TV  | Sony    | 45000 |
| 1002 | Laptop  | HP      | 39800 |
| 1003 | Mobile  | Samsung | 19900 |
| 1004 | Speaker | Boat    |  1000 |
| 1008 | PC      | Dell    | 40000 |
+------+---------+---------+-------+
5 rows in set (0.00 sec)

mysql> select * from product1;
+------+---------+---------+-------+
| id   | name    | brand   | price |
+------+---------+---------+-------+
| 1001 | LED TV  | Sony    | 45000 |
| 1002 | Laptop  | HP      | 39800 |
| 1003 | Mobile  | Samsung | 19900 |
| 1004 | Speaker | Boat    |  1002 |
| 1008 | PC      | Dell    | 40000 |
+------+---------+---------+-------+
5 rows in set (0.00 sec)


//delete record
mysql> select * from product1;
+------+---------+---------+-------+
| id   | name    | brand   | price |
+------+---------+---------+-------+
| 1001 | LED TV  | Sony    | 45000 |
| 1002 | Laptop  | HP      | 39800 |
| 1003 | Mobile  | Samsung | 19900 |
| 1004 | Speaker | Boat    |  1002 |
| 1008 | PC      | Dell    | 40000 |
+------+---------+---------+-------+
5 rows in set (0.00 sec)

mysql> select * from product1;
+------+---------+---------+-------+
| id   | name    | brand   | price |
+------+---------+---------+-------+
| 1001 | LED TV  | Sony    | 45000 |
| 1003 | Mobile  | Samsung | 19900 |
| 1004 | Speaker | Boat    |  1002 |
| 1008 | PC      | Dell    | 40000 |
+------+---------+---------+-------+
4 rows in set (0.00 sec)

 
*/
