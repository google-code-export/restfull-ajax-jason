/**
 * 
 */
package com.tuji.orm.hbm;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tuji.orm.AnnotationHibernateConfiguration;
import com.tuji.orm.IPersistence;
import com.tuji.orm.entity.AbstractSerializable;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月4日
 */
public class HibernatePersistence implements IPersistence {

	private SessionFactory sessionFactory;

	private static final Logger LOG = Logger
			.getLogger(HibernatePersistence.class.getName());

	/**
	 * @param annotationHibernateConfiguration
	 */
	public HibernatePersistence(
			AnnotationHibernateConfiguration annotationHibernateConfiguration) {
		this.sessionFactory = annotationHibernateConfiguration
				.getSessionFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#contains(com.tuji.orm.entity.AbstractSerializable
	 * )
	 */
	public boolean contains(AbstractSerializable entity) {
		return getSession().contains(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#delete(com.tuji.orm.entity.AbstractSerializable
	 * )
	 */
	public void delete(AbstractSerializable entity) {
		Session session = getSession();

		try {
			session.beginTransaction();
			session.delete(entity);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#deleteAll(java.util.Collection)
	 */
	public void deleteAll(Collection<? extends Serializable> entities) {
		Session session = getSession();

		try {
			session.beginTransaction();

			for (Object entity : entities) {
				session.delete(entity);
			}

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#findByNamedParam(java.lang.String,
	 * java.lang.String[], java.lang.Object[])
	 */
	public List findByNamedParam(String queryString, String[] paramNames,
			Object[] values) {
		if (paramNames.length != values.length) {
			throw new IllegalArgumentException(
					"Length of paramNames array must match length of values array");
		}

		Query query = getSession().createQuery(queryString);

		for (int i = 0; i < values.length; i++) {
			if (values[i] instanceof Collection) {
				query.setParameterList(paramNames[i], (Collection) values[i]);
			} else if (values[i] instanceof Object[]) {
				query.setParameterList(paramNames[i], (Object[]) values[i]);
			} else {
				query.setParameter(paramNames[i], values[i]);
			}
		}

		return query.list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#get(java.lang.Object, java.lang.Class)
	 */
	public <T> T get(Serializable id, Class<T> clazz) {
		return (T) getSession().get(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#load(java.lang.Object, java.lang.Class)
	 */
	public <T> T load(Serializable id, Class<T> clazz) {
		// TODO Auto-generated method stub
		return (T) getSession().load(clazz, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#loadAll(java.lang.Class)
	 */
	public <T> List<T> loadAll(Class<T> clazz) {
		return getSession().createQuery("from " + clazz.getSimpleName()).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#merge(com.tuji.orm.entity.AbstractSerializable)
	 */
	public void merge(AbstractSerializable entity) {
		Session session = getSession();

		try {
			session.beginTransaction();

			session.merge(entity);

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#persist(com.tuji.orm.entity.AbstractSerializable
	 * )
	 */
	public void persist(AbstractSerializable entity) {
		Session session = getSession();

		try {
			session.beginTransaction();

			session.persist(entity);

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#refresh(com.tuji.orm.entity.AbstractSerializable
	 * )
	 */
	public void refresh(AbstractSerializable entity) {
		Session session = getSession();

		try {
			session.beginTransaction();

			session.refresh(entity);

			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#save(com.tuji.orm.entity.AbstractSerializable)
	 */
	public void save(AbstractSerializable entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.save(entity);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IPersistence#saveOrUpdate(com.tuji.orm.entity.
	 * AbstractSerializable)
	 */
	public void saveOrUpdate(AbstractSerializable entity) {
		getSession().saveOrUpdate(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.tuji.orm.IPersistence#update(com.tuji.orm.entity.AbstractSerializable
	 * )
	 */
	public void update(AbstractSerializable entity) {
		Session session = getSession();
		try {
			session.beginTransaction();
			session.update(entity);
			session.getTransaction().commit();
		} catch (Exception ex) {
			session.getTransaction().rollback();
		} finally {
			session.close();
		}
	}

	/**
	 * 
	 * @return
	 */
	private Session getSession() {
		return this.sessionFactory.openSession();
	}
}
