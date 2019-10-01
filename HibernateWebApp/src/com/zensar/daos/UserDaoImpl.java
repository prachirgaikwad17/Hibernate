package com.zensar.daos;

import java.sql.*;
import java.util.*;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.User;

/**
 * @author Prachi Gaikwad
 * @version 2.0
 * @creation_date 21st Sep 2019 5.29PM
 * @modification_date 28th Sep 2019 11:12AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Data Access Object Interface.
 * 				It is used in Persistence Layer of Application.
 *    
 */

public class UserDaoImpl implements UserDao{

	private Session session;
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	Configuration c=new Configuration().configure();
	SessionFactory f=c.buildSessionFactory();
	session=f.openSession();	
	}
	
	
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		Transaction t=session.beginTransaction();
		session.save(user);
		t.commit();
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		Transaction t=session.beginTransaction();
		session.update(user);
		t.commit();
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		Transaction t=session.beginTransaction();
		session.delete(user);
		t.commit();
	}

	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return session.get(User.class,username);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		Query q=session.createQuery("from User");
		return q.getResultList();
	}

	
	
}
