package org.mini.web.system.action;

import java.util.List;

import javax.annotation.Resource;

import org.mini.common.model.Pager;
import org.mini.framework.action.BaseAction;
import org.mini.model.system.SystemInfo;
import org.mini.service.SystemInfoService;

import com.opensymphony.xwork2.Action;

/**
 * 
 * @author ancye
 *
 */
public class SystemInfoAction extends BaseAction {
	
	@Resource
	private SystemInfoService systemInfoService;
	private List<SystemInfo> list;
	private Pager pager;
	private SystemInfo systemInfo;
	private long id;
	
	public List<SystemInfo> getList() {
		return list;
	}
	public Pager getPager() {
		return pager;
	}
	public SystemInfo getSystemInfo() {
		return systemInfo;
	}
	public void setId(long id) {
		this.id = id;
	}

	public String execute() throws Exception {
		list = systemInfoService.search(null);
		
		if(pager == null) {
			pager = new Pager();
		}
		
		pager.setCount(list.size());
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String list() throws Exception {
		list = systemInfoService.search(systemInfo);
		
		if(pager == null) {
			pager = new Pager();
		}
		
		pager.setCount(list.size());
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String view() throws Exception {
		if(id != 0) {
			systemInfo = systemInfoService.get(id);
		}
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String delete() throws Exception {
		systemInfoService.delete(id);

		setIsSuccess(true);

		return Action.INPUT;
	}

	public String save() throws Exception {
		if(systemInfo.getId() != 0) {
			systemInfoService.update(systemInfo);
		} else {
			systemInfoService.insert(systemInfo);
		}

		setIsSuccess(true);

		return Action.INPUT;
	}

}
