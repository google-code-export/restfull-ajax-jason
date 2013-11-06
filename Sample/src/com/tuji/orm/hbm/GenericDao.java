/**
 * 
 */
package com.tuji.orm.hbm;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tuji.orm.IGenericDao;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月6日
 */
@SuppressWarnings("unchecked")
public class GenericDao<T> implements IGenericDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	private Class<T> type;

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Class<T> type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#getById(long)
	 */
	public T findById(Serializable id) {
		return (T) getSession().get(type, id);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#findAll()
	 */
	public List<T> findAll() {
		return getSession().createCriteria(type).list();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#findBy(java.util.SortedMap)
	 */
	public List<T> findBy(SortedMap<String, ?> properties) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#save(java.lang.Object)
	 */
	public Long save(T entity) {
		return (Long) getSession().save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#update(java.lang.Object)
	 */
	public void update(T entity) {
		getSession().merge(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		getSession().delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.IGenericDao#deleteById(long)
	 */
	public void deleteById(Serializable id) {
		delete(findById(id));
	}

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
