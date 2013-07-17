package org.mini.model.system;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.mini.model.IdEntity;

/**
 * @author ancye
 *
 */
@Entity
@Table(name="sys_role")
public class Role extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 340375014917118009L;

	@Column(name="role_name")
	private String roleName;
	
	@Column(name="role_desc")
	private String roleDesc;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDesc() {
		return roleDesc;
	}

	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	
	
	
}
