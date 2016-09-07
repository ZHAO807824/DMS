package com.dms.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dms.entity.user.Student;

/**
 * 学生信息
 * 
 * @author zhao
 *
 */
@Repository("studentDao")
public interface IStudentDao {

	/**
	 * 遍历学生列表
	 * 
	 * @return
	 */
	public List<Student> query();
}
