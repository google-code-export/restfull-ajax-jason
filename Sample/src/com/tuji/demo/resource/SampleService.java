/**
 * 
 */
package com.tuji.demo.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.tuji.demo.bean.AbstractSerializable;
import com.tuji.demo.service.UserService;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月5日
 */
@Path("sample")
public class SampleService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AbstractSerializable> getAllUsers() {
		return UserService.getInstance().getUsers();
	}
}
