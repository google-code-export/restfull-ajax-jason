/**
 * 
 */
package com.tuji.demo.bean;

import java.io.Serializable;

import com.tuji.demo.util.Util;

/**
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年10月29日
 */
@SuppressWarnings("serial")
public abstract class AbstractSerializable implements Serializable {
	public String toXML() {
		return Util.toXML(this);
	}

	public String toJason() {
		return Util.toJson(this);
	}

	public String toString() {
		return toJason();
	}
}
