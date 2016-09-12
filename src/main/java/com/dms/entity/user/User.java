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
		setGender(gender);
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
		if (gender.equals(1))
			return "女";
		if (gender.equals(0))
			return "男";
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
		if (gender.equals("男"))
			this.gender = "0";
		if (gender.equals("女"))
			this.gender = "1";
	}

	@Override
	public String toString() {
		return "User [fullName=" + fullName + ", houseName=" + houseName + ", gender=" + gender + "]";
	}

}
