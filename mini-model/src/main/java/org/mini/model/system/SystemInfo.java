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
@Table(name="sys_system_info")
public class SystemInfo extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -853219529555290415L;

	@Column(name="sys_name")
	private String sysName;
	
	@Column(name="sys_url")
	private String sysUrl;
	
	@Column(name="sys_desc")
	private String sysDesc;

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public String getSysUrl() {
		return sysUrl;
	}

	public void setSysUrl(String sysUrl) {
		this.sysUrl = sysUrl;
	}

	public String getSysDesc() {
		return sysDesc;
	}

	public void setSysDesc(String sysDesc) {
		this.sysDesc = sysDesc;
	}

	

}
