package org.dao.imp;
import org.dao.LoginDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Login;
public class LoginDaoImp implements LoginDao{

	public Login validate(String username, String pwd) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			Query query = session.createQuery("from Login where userid = ? and pwd = ?");
			query.setParameter(0, username);
			query.setParameter(1, pwd);
			query.setMaxResults(1);
			Login login = (Login) query.uniqueResult();
			if(login != null) {
				return login;
			}else {
				System.out.println(username + " " + pwd);
				return null;
			}
		}catch (Exception e) {
			return null;
		}
	}
	
	public void insert(Login login) {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			session.save(login);
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
