package org.dao.imp;
import java.util.List;
import org.dao.GoodDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Good;
public class GoodDaoImp implements GoodDao{

	public List getAll() {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			List list = session.createQuery("from Good order by goodprice").list();
			ts.commit();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Good getOneGood(String goodid) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session.createQuery("from Good where goodid = ?");
			query.setParameter(0, goodid);
			query.setMaxResults(1);
			Good good = (Good)query.uniqueResult();
			ts.commit();
			session.clear();
			return good;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}