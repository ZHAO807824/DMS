package com.dms.entity;

import com.dms.entity.IdEntity;

/**
 * 用户
 * 
 * @author zhao
 *
 */
public class Admin extends IdEntity {
	private String email;
	private String password;
	private Integer role;

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

	@Override
	public String toString() {
		return "Admin [email=" + email + ", password=" + password + ", role=" + role + "]";
	}

}
