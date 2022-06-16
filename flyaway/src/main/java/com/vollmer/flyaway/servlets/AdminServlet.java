package com.vollmer.flyaway.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vollmer.flyaway.dao.AirlineDao;
import com.vollmer.flyaway.dao.DestDao;
import com.vollmer.flyaway.dao.FlightDao;
import com.vollmer.flyaway.dao.SourceDao;
import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Destination;
import com.vollmer.flyaway.dto.Flight;
import com.vollmer.flyaway.dto.Source;

public class AdminServlet extends HttpServlet {
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
		ArrayList<Flight> flights = null;
		ArrayList<Destination> destinations = null;
		ArrayList<Source> sources = null;
		ArrayList<Airline> airlines = null;
		
		flights = flightDao.getAllFlights();
		destinations = destDao.getDestinations();
		sources = sourceDao.getSources();
		airlines = airlineDao.getAirlines();
		
		request.setAttribute("flights", flights);
		request.setAttribute("destinations", destinations);
		request.setAttribute("sources", sources);
		request.setAttribute("airlines", airlines);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./adminPage.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
