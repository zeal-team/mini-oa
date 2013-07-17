package org.mini.persist.system.dao.impl;

import java.util.List;

import org.mini.common.config.Config;
import org.mini.framework.dao.impl.GenericDAOImpl;
import org.mini.model.system.Role;
import org.mini.persist.system.dao.RoleDao;
import org.springframework.stereotype.Repository;
/**
 * @author ancye
 *
 */
@Repository
public class RoleDaoImpl extends GenericDAOImpl<Role> implements RoleDao {
	private final String QUERY_ROLE = "queryRole";

	@Override
	public void insert(Role role) throws Exception {
		super.insert(null, role);

	}

	@Override
	public void update(Role role) throws Exception {
		super.update(null, role);

	}

	@Override
	public List<Role> search(Role role) throws Exception {
		if(Config.IS_HIBERNATE) {
			if (role == null) {
				return super.queryAll(null);
			}
			return super.queryAll(QUERY_ROLE, role);
		} else {
			return super.queryAll(QUERY_ROLE, role);
		}
	}

	@Override
	public Role get(long id) throws Exception {
		return super.queryById(null, id);
	}

	@Override
	public void delete(long id) throws Exception {
		super.delete(null, id);

	}

}
