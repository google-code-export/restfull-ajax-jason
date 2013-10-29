/**
 * 
 */
package com.tuji.demo.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.junit.Before;
import org.junit.Test;

import com.tuji.demo.bean.User;
import com.tuji.demo.util.Util;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月29日
 */

public class MainJson {
	@Test
	public void testGetAll() {
		try {
			System.err.println(target.path("")
					.request(MediaType.APPLICATION_JSON).get(String.class));

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testGetByName() {
		try {
			System.err.println(target.path("/walle").request()
					.get(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testCreate() {
		try {
			Entity<String> entity = Entity.entity(
					Util.toJson(new User("Helen", "Password")),
					MediaType.APPLICATION_JSON);
			System.err.println(target.path("").request().post(entity)
					.readEntity(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			Entity<String> entity = Entity.entity(
					Util.toJson(new User("Eva", "Password")),
					MediaType.APPLICATION_JSON);
			System.err.println(target.path("/he").request().put(entity)
					.readEntity(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			System.err
					.println(target.path("/hee").request().delete(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Before
	public void setUp() {
		Client c = ClientBuilder.newClient();
		target = c.target("http://127.0.0.1:8080/Sample/demo/json");
	}

	private WebTarget target;
}
