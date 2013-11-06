/**
 * 
 */
package com.tuji.orm.service;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月6日
 */
public interface IService<T> {
	void save(T entity);

	void update(T entity);

	void delete(T entity);

	List<T> findAll();

	List<T> find(T entity);

	T findById(Serializable id);
}
