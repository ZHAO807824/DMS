package com.dms.entity.user;

import java.util.Date;

import com.dms.entity.IdEntity;

/**
 * 学生信息
 * 
 * @author zhao
 *
 */
public class Student extends IdEntity {
	private String stuName;
	private String stuSex;
	private Date stuDate;
	private String stuDepar;
	private String stuClass;
	private String houseId;
	private String dormId;
	private String bedId;
	private String inOut;

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public String getStuSex() {
		return stuSex;
	}

	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}

	public Date getStuDate() {
		return stuDate;
	}

	public void setStuDate(Date stuDate) {
		this.stuDate = stuDate;
	}

	public String getStuDepar() {
		return stuDepar;
	}

	public void setStuDepar(String stuDepar) {
		this.stuDepar = stuDepar;
	}

	public String getStuClass() {
		return stuClass;
	}

	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getDormId() {
		return dormId;
	}

	public void setDormId(String dormId) {
		this.dormId = dormId;
	}

	public String getBedId() {
		return bedId;
	}

	public void setBedId(String bedId) {
		this.bedId = bedId;
	}

	public String getInOut() {
		return inOut;
	}

	public void setInOut(String inOut) {
		this.inOut = inOut;
	}

	@Override
	public String toString() {
		return "Student [stuName=" + stuName + ", stuSex=" + stuSex + ", stuDate=" + stuDate + ", stuDepar=" + stuDepar
				+ ", stuClass=" + stuClass + ", houseId=" + houseId + ", dormId=" + dormId + ", bedId=" + bedId
				+ ", inOut=" + inOut + "]";
	}

}
