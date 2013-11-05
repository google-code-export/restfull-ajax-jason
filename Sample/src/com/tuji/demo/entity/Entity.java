package com.tuji.demo.entity;

/**
 * 
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月5日
 */
public class Entity {
	private String filed;
	private String width;
	private String title;

	/**
	 * @return the filed
	 */
	public String getFiled() {
		return filed;
	}

	/**
	 * @param filed
	 *            the filed to set
	 */
	public void setFiled(String filed) {
		this.filed = filed;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filed == null) ? 0 : filed.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((width == null) ? 0 : width.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (filed == null) {
			if (other.filed != null)
				return false;
		} else if (!filed.equals(other.filed))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (width == null) {
			if (other.width != null)
				return false;
		} else if (!width.equals(other.width))
			return false;
		return true;
	}

	/**
	 * @param filed
	 * @param width
	 * @param title
	 */
	public Entity(String filed, String width, String title) {
		super();
		this.filed = filed;
		this.width = width;
		this.title = title;
	}

	/**
	 * 
	 */
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
