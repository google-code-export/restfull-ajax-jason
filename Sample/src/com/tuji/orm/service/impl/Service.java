/**
 * 
 */
package com.tuji.orm.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tuji.orm.IGenericDao;
import com.tuji.orm.service.IService;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月6日
 */
@Repository
@Transactional
public class Service<T> implements IService<T> {
	@Autowired
	private IGenericDao<T> genericDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#save(java.lang.Object)
	 */
	public void save(T entity) {
		genericDao.save(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#update(java.lang.Object)
	 */
	public void update(T entity) {
		genericDao.update(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#delete(java.lang.Object)
	 */
	public void delete(T entity) {
		genericDao.delete(entity);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#findAll()
	 */
	public List<T> findAll() {
		return genericDao.findAll();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#find(java.lang.Object)
	 */
	public List<T> find(T entity) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.tuji.orm.service.IService#findById(java.io.Serializable)
	 */
	public T findById(Serializable id) {
		return genericDao.findById(id);
	}

}
