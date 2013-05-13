/**
 * 
 */
package org.mini.common.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Pager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4217011761175874183L;
	private int size = 10;
	private int index = 1;
	private int count;
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public int getTotalPage() {
		return count / size + (count % size == 0 ? 0 : 1);
	}
}
