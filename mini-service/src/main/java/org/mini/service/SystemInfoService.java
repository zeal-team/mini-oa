package org.mini.service;

import java.util.List;

import org.mini.model.system.SystemInfo;

/**
 * @author ancye
 *
 */
public interface SystemInfoService {
	void insert(SystemInfo systemInfo) throws Exception;
	void update(SystemInfo systemInfo) throws Exception;
	List<SystemInfo> search(SystemInfo systemInfo) throws Exception;
	SystemInfo get(long id) throws Exception;
	void delete(long id) throws Exception;

}
