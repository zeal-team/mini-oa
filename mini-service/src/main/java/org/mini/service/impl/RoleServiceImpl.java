package org.mini.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mini.model.system.Role;
import org.mini.persist.system.dao.RoleDao;
import org.mini.service.RoleService;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ancye
 *
 */
@Service
@Repository
public class RoleServiceImpl implements RoleService {
	
	@Resource
	private RoleDao roleDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insert(Role role) throws Exception {
		roleDao.insert(role);

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(Role role) throws Exception {
		roleDao.update(role);

	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Role> search(Role role) throws Exception {
		return roleDao.search(role);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Role get(long id) throws Exception {
		return roleDao.get(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(long id) throws Exception {
		roleDao.delete(id);

	}

}
