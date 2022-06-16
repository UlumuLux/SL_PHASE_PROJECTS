package com.vollmer.flyaway.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vollmer.flyaway.dao.AirlineDao;
import com.vollmer.flyaway.dao.DestDao;
import com.vollmer.flyaway.dao.FlightDao;
import com.vollmer.flyaway.dao.SourceDao;
import com.vollmer.flyaway.dao.UserDao;
import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Flight;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FlightDao flightDao;
	private SourceDao sourceDao;
	private DestDao destDao;
	private AirlineDao airlineDao;
	
	public void init() {
		flightDao = new FlightDao();
		sourceDao = new SourceDao();
		destDao = new DestDao();
		airlineDao = new AirlineDao();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String source = request.getParameter("source");
		String dest = request.getParameter("dest");
		String date = request.getParameter("date");
		String ppl = request.getParameter("ppl");
		ArrayList<Flight> flights = null;
		ArrayList<Airline> airlines = null;
		
		if(ppl.equals("")) {
			ppl = "2";
		}
		
		int d = destDao.getDest(dest);
		int s = sourceDao.getSource(source);
		
		flights = flightDao.getFlights(s, d, date);
		
		airlines = airlineDao.getAirlines();
		
		request.setAttribute("flights", flights);
		request.setAttribute("airlines", airlines);
		request.setAttribute("source", source);
		request.setAttribute("dest", dest);
		request.setAttribute("ppl", ppl);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./availableFlights.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
