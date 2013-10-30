/**
 * 
 */
package com.tuji.demo.util;

import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.tuji.demo.bean.User;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月30日
 */
public class AnnotationHibernateUtil {
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session beginWriteTransaction() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.setFlushMode(FlushMode.AUTO);

		return session;
	}

	public static Session beginViewTransaction() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.setFlushMode(FlushMode.NEVER);

		return session;
	}

	public static void rollbackTransaction() {
		if (trasactionIsActive()) {
			sessionFactory.getCurrentSession().getTransaction().rollback();
		}
	}

	public static void commitTransaction() throws HibernateException {
		if (trasactionIsActive()) {
			sessionFactory.getCurrentSession().getTransaction().commit();
		}
	}

	public static boolean trasactionIsActive() {
		return sessionFactory.getCurrentSession().getTransaction().isActive();
	}

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration().configure()
					.addPackage("com.tuji.demo.bean")
					.addAnnotatedClass(User.class).buildSessionFactory();
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
}
