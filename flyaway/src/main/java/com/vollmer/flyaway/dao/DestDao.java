package com.vollmer.flyaway.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Destination;
import com.vollmer.flyaway.util.HibernateUtil;

public class DestDao {
	
	// get dest by name
		public int getDest(String dest) {
			Transaction transaction = null;
			int dest_id = 0;
			try(Session session = HibernateUtil.getSessionFactory().openSession()) {
				transaction = session.beginTransaction();
				Query query=session.createQuery("from destinations where dest_name=:dest");
				query.setParameter("dest", dest);
				Destination d = (Destination) query.uniqueResult();
				dest_id = d.getId();
				transaction.commit();
			} catch(Exception e) {
				if(transaction != null) {
					//transaction.rollback();
				}
				e.printStackTrace();
			}
			return dest_id;
		}
		
	// get destinations
	public ArrayList<Destination> getDestinations() {
		Transaction transaction = null;
		ArrayList<Destination> destinations = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from destinations");
			destinations = (ArrayList<Destination>) query.getResultList();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return destinations;
	}
}
