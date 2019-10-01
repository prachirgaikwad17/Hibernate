package com.zensar.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zensar.daos.SQlException;
import com.zensar.daos.UserDao;
import com.zensar.daos.UserDaoImpl;
import com.zensar.entities.User;
import com.zensar.exceptions.ServiceException;
import com.zensar.services.UserService;
import com.zensar.services.UserServiceImpl;

/**
 * @author Prachi Gaikwad
 * @version 2.0
 * @creation_date 21st Sep 2019 5.29PM
 * @modification_date 28th Sep 2019 11.50AM
 * @copyright Zensar Technologies. All rights reserved.
 * @description It is Data Access Object Interface.
 * 				It is used in Persistence Layer of Application.
 *    
 */


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/checkuser")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//Call business Layer Component
		private UserService userService;
		
		@Override
		public void init() throws ServletException {
			// TODO Auto-generated method stub
			UserDao userDao=new UserDaoImpl();
			UserService userService=new UserServiceImpl();
			((UserServiceImpl) userService).setUserDao(userDao);
			setUserService(userService);
		}
		
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

	
		
		

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String username=request.getParameter("username");
			String password=request.getParameter("passwd");
			User clientUser = new User();
			clientUser.setUsername(username);
			clientUser.setPassword(password);
			
			try {
				//invoking business logic of business layer in presentation layer
				if(userService.validateUser(clientUser))
				{
					//out.println("<p>Dear "+username+" Welcome to Online Shopping</p>");
					RequestDispatcher rd=request.getRequestDispatcher("welcome.jsp"); 
					rd.forward(request, response);
				}
				else
				{
					PrintWriter out = null;
					out.println("<p>Sorry! invalid Username/Password</p>");
					RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
					rd.include(request, response);
				}
			} catch (ServiceException | SQlException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}


}
