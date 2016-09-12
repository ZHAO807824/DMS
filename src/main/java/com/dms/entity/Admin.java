package com.dms.entity;

import com.dms.entity.IdEntity;

/**
 * 用户
 * 
 * @author zhao
 *
 */
public class Admin extends IdEntity {

	private static final long serialVersionUID = 8597235150704558206L;
	private String email;
	private String password;
	private Integer role;
	private Integer status;

	public Admin() {
	}

	public Admin(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
