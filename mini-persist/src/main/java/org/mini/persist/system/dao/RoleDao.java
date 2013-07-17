package org.mini.persist.system.dao;

import java.util.List;

import org.mini.framework.dao.GenericDao;
import org.mini.model.system.Role;

/**
 * @author ancye
 *
 */
public interface RoleDao extends GenericDao<Role> {
	void insert(Role role) throws Exception;
	void update(Role role) throws Exception;
	List<Role> search(Role role) throws Exception;
	Role get(long id) throws Exception;
	void delete(long id) throws Exception;


}
