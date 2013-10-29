/**
 * 
 */
package com.tuji.demo.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.tuji.demo.bean.AbstractSerializable;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月29日
 */
public class Util {
	public static String toJson(Object obj) {
		return JSON.toXML(obj);
	}

	public static AbstractSerializable fromJson(String json) {
		return (AbstractSerializable) JSON.fromXML(json);
	}

	public static String toXML(Object obj) {
		return XML.toXML(obj);
	}

	public static AbstractSerializable fromXML(String xml) {
		return (AbstractSerializable) XML.fromXML(xml);
	}

	private static final XStream JSON = new XStream(
			new JettisonMappedXmlDriver());
	private static final XStream XML = new XStream(new StaxDriver());
}
