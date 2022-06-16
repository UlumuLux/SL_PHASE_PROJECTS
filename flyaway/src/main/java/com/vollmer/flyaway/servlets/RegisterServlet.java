package com.vollmer.flyaway.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vollmer.flyaway.dao.UserDao;
import com.vollmer.flyaway.dto.User;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String city = request.getParameter("city");
		String postcode = request.getParameter("postcode");
		String street = request.getParameter("street");
		String housenumber = request.getParameter("housenumber");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		int role = 2;

		User newUser = new User(uname, pass, fname, lname, city, postcode, street, housenumber, phone, email, role);
		userDao.saveUser(newUser);
		
		Cookie loggedUser = new Cookie("user", uname);
		response.addCookie(loggedUser);
		
		response.sendRedirect("./index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
