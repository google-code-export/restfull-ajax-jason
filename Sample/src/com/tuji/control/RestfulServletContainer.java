/**
 * 
 */
package com.tuji.control;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.glassfish.jersey.servlet.ServletContainer;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月4日
 */
public class RestfulServletContainer extends ServletContainer {
	public void init(FilterConfig config) throws ServletException {
		super.init(config);

		String home = getServletContext().getInitParameter("sree.home");
		System.getProperties().put("sree.home", home);
	}
}
