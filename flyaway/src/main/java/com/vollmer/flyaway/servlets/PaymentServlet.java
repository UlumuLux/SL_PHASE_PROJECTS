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

/**
 * Servlet implementation class PaymentServlet
 */
public class PaymentServlet extends HttpServlet {
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
		String flight = request.getParameter("selected");
		String[] infos = flight.split(";");
		
		int source = Integer.parseInt(infos[0]);
		int dest = Integer.parseInt(infos[1]);
		int airline = Integer.parseInt(infos[2]);
		String date = infos[3];
		String time = infos[4];
		String price = infos[5];
		String ppl = infos[6];
		
		String Fdest = null;
		String Fsource = null;
		String Fairline = null;

		ArrayList<Airline> allAL = airlineDao.getAirlines();
		ArrayList<Destination> allD = destDao.getDestinations();
		ArrayList<Source> allS = sourceDao.getSources();
		
		for(Airline a : allAL) {
			if(a.getId() == airline) {
				Fairline = a.getName();
			}
		}
		
		for(Destination d : allD) {
			if(d.getId() == 5) {
				Fdest = d.getName();
			}
		}
		
		for(Source s : allS) {
			if(s.getId() == source) {
				Fsource = s.getName();
			}
		}
		
		request.setAttribute("source", Fsource);
		request.setAttribute("dest", Fdest);
		request.setAttribute("airline", Fairline);
		request.setAttribute("date", date);
		request.setAttribute("time", time);
		request.setAttribute("price", price);
		request.setAttribute("ppl", ppl);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("./payment.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
