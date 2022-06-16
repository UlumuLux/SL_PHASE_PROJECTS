package com.vollmer.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vollmer.flyaway.dao.UserDao;
import com.vollmer.flyaway.dto.User;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pword");
		User user = null;
		PrintWriter out = response.getWriter();
		
		user = userDao.getUser(uname, pass);
		if(user != null) {
			Cookie loggedUser = new Cookie("user", uname);
			response.addCookie(loggedUser);
			
			if(user.getRole() == 1) {
				response.sendRedirect("AdminServlet");
			} else if(user.getRole() == 2) {
				response.sendRedirect("./index.jsp");
			}
			
		} else {
			response.sendRedirect("./login.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
