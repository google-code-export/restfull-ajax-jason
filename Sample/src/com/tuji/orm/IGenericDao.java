/**
 * 
 */
package com.tuji.orm;

import java.io.Serializable;
import java.util.List;
import java.util.SortedMap;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月6日
 */
public interface IGenericDao<T> {
	T findById(Serializable id);

	List<T> findAll();

	List<T> findBy(SortedMap<String, ?> properties);

	Long save(T entity);

	void update(T entity);

	void delete(T entity);

	void deleteById(Serializable id);
}
