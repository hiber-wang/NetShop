package org.dao.imp;
import org.dao.PayDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Pay;

import java.util.List;
public class PayDaoImp implements PayDao{

	public List getUserPay(String userid) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session.createQuery("from Pay where userid = ?");
			query.setParameter(0, userid);
			List list = query.list();
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void insert(Pay pay) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.save(pay);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Pay pay) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.delete(pay);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Pay getOnePay(int id) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session.createQuery("from Pay where id = ?");
			query.setParameter(0, id);
			query.setMaxResults(1);
			Pay pay = (Pay)query.uniqueResult();
			ts.commit();
			session.clear();
			return pay;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
