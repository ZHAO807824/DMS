package com.dms.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.dms.entity.user.Student;

/**
 * ѧ����Ϣ
 * 
 * @author zhao
 *
 */
@Repository("studentDao")
public interface IStudentDao {

	/**
	 * ����ѧ���б�
	 * 
	 * @return
	 */
	public List<Student> query();
}
