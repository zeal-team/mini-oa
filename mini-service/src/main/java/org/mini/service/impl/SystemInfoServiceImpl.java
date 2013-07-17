package org.mini.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.mini.model.system.SystemInfo;
import org.mini.persist.system.dao.SystemInfoDao;
import org.mini.service.SystemInfoService;
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
public class SystemInfoServiceImpl implements SystemInfoService {
	@Resource
	private SystemInfoDao systemInfoDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void insert(SystemInfo systemInfo) throws Exception {
		systemInfoDao.insert(systemInfo);
		
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void update(SystemInfo systemInfo) throws Exception {
		systemInfoDao.update(systemInfo);
		
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<SystemInfo> search(SystemInfo systemInfo) throws Exception {
		return systemInfoDao.search(systemInfo);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public SystemInfo get(long id) throws Exception {
		return systemInfoDao.get(id);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	public void delete(long id) throws Exception {
		systemInfoDao.delete(id);
		
	}
	

	

}
