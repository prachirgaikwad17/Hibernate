package com.zensar.services;

import java.util.*;

import com.zensar.daos.SQlException;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;

/**
 * @author Prachi Gaikwad
 * @version 1.0
 * @creation_date 21st Sep 2019 5.57PM
 * @modification_date 21st Sep 2019 5.57PM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Business Service Interface.
 * 				It is used in Business Layer of Application.
 *    
 */



public interface UserService {

	
	void addUser(User user)throws ServiceException, SQlException;
	void updateUser(User user)throws ServiceException, SQlException;
	void removeUser(User user)throws ServiceException, SQlException;
	User findUserByUsername(String username)throws ServiceException, SQlException;
	List<User> findAllUsers()throws ServiceException, SQlException;
	
	boolean validateUser(User user)throws ServiceException, SQlException;
}
