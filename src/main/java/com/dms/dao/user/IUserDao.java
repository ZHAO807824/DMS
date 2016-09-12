package com.dms.dao.user;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.dms.entity.user.User;

/**
 * 
 * @author zhao
 *
 */
@Repository("userDao")
public interface IUserDao {

	/**
	 * 插入User
	 * @param user
	 * @return
	 */
	public Integer insertUser(User user);
	
	/**
	 * 插入user_admin
	 * @param userId
	 * @param adminId
	 */
	public void insertUserAdmin(@Param("userId") Integer userId,@Param("adminId") Integer adminId);
	
}
