package org.mini.persist.system.dao.impl;

import java.util.List;

import org.mini.common.config.Config;
import org.mini.framework.dao.impl.GenericDAOImpl;
import org.mini.model.system.SystemInfo;
import org.mini.persist.system.dao.SystemInfoDao;
import org.springframework.stereotype.Repository;
/**
 * @author ancye
 *
 */
@Repository
public class SystemInfoDaoImpl extends GenericDAOImpl<SystemInfo> implements SystemInfoDao {
	private final String QUERY_SYSTEMINFO = "querySystemInfo";

	@Override
	public void insert(SystemInfo systemInfo) throws Exception {
		super.insert(null, systemInfo);

	}

	@Override
	public void update(SystemInfo systemInfo) throws Exception {
		super.insert(null, systemInfo);

	}

	@Override
	public List<SystemInfo> search(SystemInfo systemInfo) throws Exception {
		if(Config.IS_HIBERNATE) {
			if (systemInfo == null) {
				return super.queryAll(null);
			}
			return super.queryAll(QUERY_SYSTEMINFO, systemInfo);
		} else {
			return super.queryAll(QUERY_SYSTEMINFO, systemInfo);
		}
	}

	@Override
	public SystemInfo get(long id) throws Exception {
		return super.queryById(null, id);
	}

	@Override
	public void delete(long id) throws Exception {
		super.delete(null, id);
	}

}
