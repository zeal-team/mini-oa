package org.mini.web.system.action;

import java.util.List;

import javax.annotation.Resource;

import org.mini.common.model.Pager;
import org.mini.framework.action.BaseAction;
import org.mini.model.system.Role;
import org.mini.service.RoleService;

import com.opensymphony.xwork2.Action;
/**
 * 
 * @author ancye
 *
 */
public class RoleAction extends BaseAction {
	
	@Resource
	private RoleService roleService; 
	private List<Role> roleList;
	private Pager pager;
	private Role role;
	private long id;
	
	public List<Role> getRoleList() {
		return roleList;
	}

	public Pager getPager() {
		return pager;
	}

	public Role getRole() {
		return role;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String execute() throws Exception {
		roleList = roleService.search(null);
		
		if(pager == null) {
			pager = new Pager();
		}
		
		pager.setCount(roleList.size());
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String list() throws Exception {
		roleList = roleService.search(role);
		
		if(pager == null) {
			pager = new Pager();
		}
		
		pager.setCount(roleList.size());
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String view() throws Exception {
		if(id != 0) {
			role = roleService.get(id);
		}
		
		setIsSuccess(true);

		return Action.SUCCESS;
	}

	public String delete() throws Exception {
		roleService.delete(id);

		setIsSuccess(true);

		return Action.INPUT;
	}

	public String save() throws Exception {
		if(role.getId() != 0) {
			roleService.update(role);
		} else {
			roleService.insert(role);
		}

		setIsSuccess(true);

		return Action.INPUT;
	}

}
