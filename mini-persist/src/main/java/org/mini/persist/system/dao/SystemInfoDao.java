package org.mini.persist.system.dao;

import java.util.List;

import org.mini.framework.dao.GenericDao;
import org.mini.model.system.SystemInfo;

/**
 * @author ancye
 *
 */
public interface SystemInfoDao extends GenericDao<SystemInfo> {
	void insert(SystemInfo systemInfo) throws Exception;
	void update(SystemInfo systemInfo) throws Exception;
	List<SystemInfo> search(SystemInfo systemInfo) throws Exception;
	SystemInfo get(long id) throws Exception;
	void delete(long id) throws Exception;

}
