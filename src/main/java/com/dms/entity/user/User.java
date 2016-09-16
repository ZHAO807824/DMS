package com.dms.entity.user;

import com.dms.entity.IdEntity;

/**
 * 用户信息
 * 
 * @author zhao
 *
 */
public class User extends IdEntity {
	private static final long serialVersionUID = -175804738566057427L;
	private String fullName;
	private String houseName;
	private String gender;

	public User() {
	}

	public User(String fullName, String houseName, String gender) {
		this.fullName = fullName;
		this.houseName = houseName;
		this.gender=gender;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHouseName() {
		return houseName;
	}

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", houseName=" + houseName + ", gender=" + gender + "]";
	}

}
