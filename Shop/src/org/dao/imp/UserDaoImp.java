package org.dao.imp;
import java.util.List;
import org.dao.UserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Usr;
public class UserDaoImp implements UserDao{

	public Usr getOneUser(String userid) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session.createQuery("from Usr where userid = ?");
			query.setParameter(0, userid);
			query.setMaxResults(1);
			Usr user = (Usr) query.uniqueResult();
			ts.commit();
			session.clear();
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void update(Usr user) {
		try{
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.merge(user);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insert(Usr user) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.save(user);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Usr user){
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.delete(user);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
