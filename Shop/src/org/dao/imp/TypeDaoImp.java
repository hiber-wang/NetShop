package org.dao.imp;
import java.util.List;
import org.dao.TypeDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.model.Type;
public class TypeDaoImp implements TypeDao{

	public List getAll() {
		try {
			Session session = org.util.HibernateSessionFactory.getSession();
			Transaction ts = session.beginTransaction();
			List list = session.createQuery("from Type").list();
			ts.commit();
			org.util.HibernateSessionFactory.closeSession();
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Type getOneType(Integer id) {
		Session session = org.util.HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		Query query = session.createQuery("from Type where id = ?");
		query.setParameter(0, id);
		query.setMaxResults(1);
		Type type = (Type)query.uniqueResult();
		ts.commit();
		org.util.HibernateSessionFactory.closeSession();
		return type;
	}
	
}
