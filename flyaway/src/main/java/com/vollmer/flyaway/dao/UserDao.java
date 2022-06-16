package com.vollmer.flyaway.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vollmer.flyaway.dto.User;
import com.vollmer.flyaway.util.HibernateUtil;

public class UserDao {

	// save user
	public void saveUser(User user) {
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
	}
	
	// get user by username
	public User getUser(String uname, String pass) {
		Transaction transaction = null;
		User user = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("from user where username=:uname and user_pass=:pass");
			query.setParameter("uname", uname);
	        query.setParameter("pass", pass);
			user = (User) query.uniqueResult();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
		return user;
	}
	
	// change admin pw
	public void changePw(String pw, String uname) {
		Transaction transaction = null;
		User user = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			Query query=session.createQuery("update user set user_pass=:pw where username=:uname");
			query.setParameter("pw", pw);
			query.setParameter("uname", uname);
			query.executeUpdate();
			transaction.commit();
		} catch(Exception e) {
			if(transaction != null) {
				//transaction.rollback();
			}
			e.printStackTrace();
		}
	}
}
