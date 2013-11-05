package com.tuji.demo;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.tuji.demo.controller.ColumnsResource;

/**
 * 
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月5日
 */
public class MyApplication extends ResourceConfig {
	public MyApplication() {
		super(ColumnsResource.class, JacksonFeature.class);
	}
}