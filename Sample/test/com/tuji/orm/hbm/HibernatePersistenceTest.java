/**
 * 
 */
package com.tuji.orm.hbm;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.tuji.orm.AnnotationHibernateConfiguration;
import com.tuji.orm.entity.User;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月4日
 */
public class HibernatePersistenceTest {
	private HibernatePersistence persistence;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		persistence = new HibernatePersistence(
				new AnnotationHibernateConfiguration());
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#delete(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testDelete() {
		User user = new User();
		user.setId(4);
		persistence.delete(user);
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#deleteAll(java.util.Collection)}
	 * .
	 */
	@Test
	public void testDeleteAll() {
		User[] users = new User[2];
		users[1] = new User();
		users[1].setId(2);

		users[0] = new User();
		users[0].setId(6);

		persistence.deleteAll(Arrays.asList(users));

	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#findByNamedParam(java.lang.String, java.lang.String[], java.lang.Object[])}
	 * .
	 */
	@Test
	public void testFindByNamedParam() {
		String hql = "from User where name=:name";
		String[] paramNames = new String[] { "name" };
		Object[] values = new Object[] { "togeek" };

		System.err.println(persistence
				.findByNamedParam(hql, paramNames, values));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#get(java.io.Serializable, java.lang.Class)}
	 * .
	 */
	@Test
	public void testGet() {
		System.err.println(persistence.get(Integer.valueOf(10), User.class));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#load(java.io.Serializable, java.lang.Class)}
	 * .
	 */
	@Test
	public void testLoad() {
		System.err.println(persistence.load(Integer.valueOf(10), User.class));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#loadAll(java.lang.Class)}.
	 */
	@Test
	public void testLoadAll() {
		System.err.println(persistence.loadAll(User.class));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#merge(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testMerge() {
		User user = new User();
		user.setId(10);
		user.setPassword("merged");
		user.setName("Watch");

		System.err.println(persistence.get(10, User.class));

		persistence.merge(user);

		System.err.println(persistence.get(10, User.class));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#persist(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testPersist() {
		User user = new User();
		user.setId(10);
		user.setPassword("persist");

		System.err.println(persistence.get(10, User.class));

		persistence.merge(user);

		System.err.println(persistence.get(10, User.class));
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#refresh(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testRefresh() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#save(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#saveOrUpdate(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testSaveOrUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link com.tuji.orm.hbm.HibernatePersistence#update(com.tuji.orm.entity.AbstractSerializable)}
	 * .
	 */
	@Test
	public void testUpdate() {
		User user = new User();
		user.setId(10);
		user.setPassword("update2");

		System.err.println(persistence.get(10, User.class));

		persistence.update(user);

		System.err.println(persistence.get(10, User.class));
	}
}
