package bg.uni_sofia.fmi.corejava.threads.producer_consumer;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;

public class Util {

	private static SessionFactory sf = new Configuration().configure()
			.buildSessionFactory();

	private static Long lastId = null;

	static {
		Session session = sf.openSession();
		try {
			Criteria criteria = session.createCriteria(Product.class)
					.setProjection(Projections.max("id"));
			Long maxId = (Long) criteria.uniqueResult();
			if(maxId != null){
				lastId = maxId;
			} else {
				lastId = 0l;
			}
		} catch (Exception e) {
			e.printStackTrace();
			lastId = 0l;
		} finally {
			session.close();
		}
	}

	public static synchronized long generateUniqueId() {
		lastId++;
		return lastId;
	}

	public static void saveProduct(Product product) {
		Transaction tx = null;
		Session session = sf.openSession();
		try {
			tx = session.beginTransaction();
			session.save(product);
			System.err.println("Product has been saved successfully");
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			session.close();
		}
	}

}
