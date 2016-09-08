package com.dms.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dms.entity.user.Student;

/**
 * 
 * @author zhao
 *
 */
@Repository("studentDao")
public interface IStudentDao {

	/**
	 * 
	 * @return
	 */
	public List<Student> query();
	
}
