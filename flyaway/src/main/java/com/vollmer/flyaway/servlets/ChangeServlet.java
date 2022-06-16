package com.vollmer.flyaway.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vollmer.flyaway.dao.UserDao;

/**
 * Servlet implementation class ChangeServlet
 */
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDao userDao;
	
	public void init() {
		userDao = new UserDao();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pw = request.getParameter("pw");
		Cookie cookies[] = request.getCookies();
		String uname = null;
		for(Cookie c : cookies) {
			if(c.getName().equals("user")) {
				uname = c.getValue();
				c.setMaxAge(0);
				response.addCookie(c);
				break;
			}
		}

		userDao.changePw(pw, uname);
		
		response.sendRedirect("./login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
