/**
 * 
 */
package com.tuji.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.tuji.demo.bean.AbstractSerializable;
import com.tuji.demo.bean.User;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月29日
 */
public class UserService {
	private UserService() {
	}

	public static UserService getInstance() {
		return service;
	}

	public List<AbstractSerializable> getUsers() {
		List<AbstractSerializable> users = new ArrayList<AbstractSerializable>();

		users.add(new User("name1", "pass1"));
		users.add(new User("name2", "pass2"));
		users.add(new User("name3", "pass3"));

		return users;
	}

	public List<User> getUsersByName(String name) {
		List<User> users = new ArrayList<User>();

		users.add(new User(name, "pass1"));
		users.add(new User(name, "pass3"));

		return users;
	}

	public User createUser(User user) {
		System.err.println("create ...");
		return user;
	}

	public User deleteUser(User user) {
		System.err.println("delete ..." + user);
		return user;
	}

	public User updateUser(User user) {
		System.err.println("update ...");
		return user;
	}

	private static UserService service = new UserService();
}
