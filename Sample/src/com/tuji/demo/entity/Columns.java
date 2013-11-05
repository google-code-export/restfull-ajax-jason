package com.tuji.demo.entity;

import java.util.Arrays;

/**
 * 
 * @author <a
 *         href="mailto:zhangtuo@statepower.net;wallellen@hotmail.com">Walle</a>
 * 
 *         2013年11月5日
 */
public class Columns {
	private Entity[] entities = null;

	public Columns() {
		Entity entity1 = new Entity();
		entity1.setFiled("f1");
		entity1.setTitle("t1");
		entity1.setWidth("100%");

		Entity entity2 = new Entity();
		entity2.setFiled("f2");
		entity2.setTitle("t3");
		entity2.setWidth("200%");

		Entity entity3 = new Entity();
		entity3.setFiled("f3");
		entity3.setTitle("t4");
		entity3.setWidth("300%");

		entities = new Entity[] { entity1, entity2, entity3 };
	}

	/**
	 * @return the entities
	 */
	public Entity[] getEntities() {
		return entities;
	}

	/**
	 * @param entities
	 *            the entities to set
	 */
	public void setEntities(Entity[] entities) {
		this.entities = entities;
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
		result = prime * result + Arrays.hashCode(entities);
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
		Columns other = (Columns) obj;
		if (!Arrays.equals(entities, other.entities))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Columns [entities=" + Arrays.toString(entities) + "]";
	}

	/**
	 * @param entities
	 */
	public Columns(Entity[] entities) {
		super();
		this.entities = entities;
	}

}
