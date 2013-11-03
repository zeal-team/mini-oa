/**
 * 
 */
package org.mini.framework.cache;

/**
 * @author Administrator
 *
 */
public interface Cache {
	
	<T extends Object> void set(String key, T value);

	<T extends Object> T get(String key);
}
