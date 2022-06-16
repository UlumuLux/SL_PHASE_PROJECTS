package com.vollmer.flyaway.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Flight;
import com.vollmer.flyaway.util.HibernateUtil;

public class AirlineDao {
	
	// get airlines
	public ArrayList<Airline> getAirlines() {
		Transaction transaction = null;
		ArrayList<Airline> airlines = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from airlines");
			airlines = (ArrayList<Airline>) query.getResultList();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return airlines;
	}
}
