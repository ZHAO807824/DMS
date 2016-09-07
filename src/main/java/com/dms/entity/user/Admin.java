package com.dms.entity.user;

import com.dms.entity.IdEntity;

/**
 * 登录用户:宿舍管理员,学生
 * 
 * @author zhao
 *
 */
public class Admin extends IdEntity {
	private String username;
	private String password;
	private Integer role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
		return "Admin [username=" + username + ", password=" + password + ", role=" + role + "]";
	}

}
