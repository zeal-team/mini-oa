/**
 * 
 */
package org.mini.model.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.mini.model.IdEntity;

/**
 * @author Administrator
 * 
 */
@Entity
@Table(name="sys_user")
public class User extends IdEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3636886603693310633L;

	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "emp_no")
	private String empNo;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "valid_flag")
	private Boolean valid;
	
	@Column(name = "create_time")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createTime;

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the empNo
	 */
	public String getEmpNo() {
		return empNo;
	}

	/**
	 * @param empNo
	 *            the empNo to set
	 */
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the valid
	 */
	public Boolean isValid() {
		return valid;
	}

	/**
	 * @param valid the valid to set
	 */
	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	/**
	 * @return the createTiem
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @param createTiem
	 *            the createTiem to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime= createTime;
	}

}
