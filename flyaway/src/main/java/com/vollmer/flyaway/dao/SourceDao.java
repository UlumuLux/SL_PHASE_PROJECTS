package com.vollmer.flyaway.dao;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vollmer.flyaway.dto.Airline;
import com.vollmer.flyaway.dto.Source;
import com.vollmer.flyaway.util.HibernateUtil;

public class SourceDao {

	// get source by name
	public int getSource(String source) {
		Transaction transaction = null;
		int source_id = 0;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from sources where source_name=:source");
			query.setParameter("source", source);
			Source s = (Source) query.uniqueResult();
			source_id = s.getId();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return source_id;
	}
	
	// get sources
	public ArrayList<Source> getSources() {
		Transaction transaction = null;
		ArrayList<Source> sources = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from sources");
			sources = (ArrayList<Source>) query.getResultList();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return sources;
	}
}
