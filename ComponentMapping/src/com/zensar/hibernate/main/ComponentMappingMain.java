package com.zensar.hibernate.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Blob;
import java.sql.Clob;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.BlobProxy;
import org.hibernate.engine.jdbc.ClobProxy;

import com.zensar.entities.Customer;
import com.zensar.entities.Name;

public class ComponentMappingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration c=new Configuration().configure();
		SessionFactory f=c.buildSessionFactory();
		Session s=f.openSession();
		Transaction t=s.beginTransaction();
		
		Name name=new Name();
		name.setFirstName("Kavya");
		name.setMiddleName("Ram");
		name.setLastName("Pawar");
		
		Customer cu=new Customer(6,name,"Female",26,"Pune");
		//cu.setAddress("Pune");
		cu.setBirthDate(LocalDate.of(1998,2,17));
		
		
		try {
			File photo=new File("./resources/1.jfif");
			FileInputStream fin=new FileInputStream(photo);
			Blob customerPhoto=BlobProxy.generateProxy(fin,photo.length());
			cu.setProfilePhoto(customerPhoto);
			
			File file2=new File("./resources/customerinfo.txt");
			FileReader fr=new FileReader(file2);
			Clob description=ClobProxy.generateProxy(fr,file2.length());
			cu.setDescription(description);
			s.save(cu);
			
			
			
			t.commit();
			s.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	private static Clob ClobProxy(FileReader fr, long length) {
		// TODO Auto-generated method stub
		return null;
	}

}
