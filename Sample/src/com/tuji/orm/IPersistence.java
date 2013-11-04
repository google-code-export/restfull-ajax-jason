/**
 * 
 */
package com.tuji.orm;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.tuji.orm.entity.AbstractSerializable;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月4日
 */
public interface IPersistence {
	<T> T get(Serializable id, Class<T> clazz);

	<T> T load(Serializable id, Class<T> clazz);

	<T> List<T> loadAll(Class<T> clazz);

	void refresh(AbstractSerializable entity);

	boolean contains(AbstractSerializable entity);

	void save(AbstractSerializable entity);

	void update(AbstractSerializable entity);

	void saveOrUpdate(AbstractSerializable entity);

	void persist(AbstractSerializable entity);

	void merge(AbstractSerializable entity);

	void delete(AbstractSerializable entity);

	void deleteAll(Collection<? extends Serializable> entities);

	List<? extends Serializable> findByNamedParam(String queryString,
			String[] paramNames, Object[] values);
}
