/**
 * 
 */
package com.tuji.demo.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tuji.demo.bean.AbstractSerializable;
import com.tuji.demo.bean.User;
import com.tuji.demo.service.UserService;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月29日
 */
@Path("xml")
@Produces(MediaType.APPLICATION_XML)
public class UserResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<AbstractSerializable> getAllUsers() {
		return UserService.getInstance().getUsers();
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.APPLICATION_XML)
	public List<User> getUsersByNames(@PathParam("name") String name) {
		return UserService.getInstance().getUsersByName(name);
	}

	@POST
	@Produces(MediaType.APPLICATION_XML)
	public User createUser(User user) {
		return UserService.getInstance().createUser(user);
	}

	@PUT
	@Path("{user}")
	@Produces(MediaType.APPLICATION_XML)
	public User updateUser(User user) {
		return UserService.getInstance().updateUser(user);
	}

	@DELETE
	@Path("{name}")
	@Produces(MediaType.APPLICATION_XML)
	public User deleteUser(@PathParam("name") String name) {
		return UserService.getInstance().deleteUser(new User(name, "123"));
	}
}