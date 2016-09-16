package com.dms.entity.user;

import com.dms.entity.IdEntity;

/**
 * 
 * @author zhao
 *
 */
public class UserAdmin extends IdEntity {

	private static final long serialVersionUID = 6625474443486174404L;

	private Integer userId;
	private Integer adminId;

	public UserAdmin() {
	}

	public UserAdmin(Integer userId, Integer adminId) {
		this.userId = userId;
		this.adminId = adminId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

}
