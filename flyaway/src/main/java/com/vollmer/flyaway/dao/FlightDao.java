package com.vollmer.flyaway.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Flight;
import com.vollmer.flyaway.util.HibernateUtil;

public class FlightDao {
	
	// get flights
	public ArrayList<Flight> getFlights(int source, int dest, String date) {
		Transaction transaction = null;
		ArrayList<Flight> flights = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from flights where flight_source=:source and flight_dest=:dest and flight_date=:date");
			query.setParameter("source", source);
	        query.setParameter("dest", dest);
	        query.setParameter("date", date);
			flights = (ArrayList<Flight>) query.getResultList();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return flights;
	}
	
	// get all flights
	public ArrayList<Flight> getAllFlights() {
		Transaction transaction = null;
		ArrayList<Flight> allFlights = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from flights");
			allFlights = (ArrayList<Flight>) query.getResultList();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return allFlights;
	}
}
