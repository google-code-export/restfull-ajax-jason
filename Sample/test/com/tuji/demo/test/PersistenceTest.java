/**
 * 
 */
package com.tuji.demo.test;

import static org.junit.Assert.assertTrue;

import org.hibernate.Session;
import org.junit.Test;

import com.tuji.demo.bean.User;
import com.tuji.demo.util.AnnotationHibernateUtil;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月31日
 */
public class PersistenceTest {
	@Test
	public void testSave() {
		Session session = null;

		try {

			session = AnnotationHibernateUtil.beginWriteTransaction();
			User user = new User("walle", "test");
			session.save(user);
			session.getTransaction().commit();
			assertTrue(true);
		} catch (Exception ex) {
			ex.printStackTrace();
			if (session != null) {
				session.getTransaction().rollback();
			}
			assertTrue(false);
		} finally {

		}

	}
}
