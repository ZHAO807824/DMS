package com.dms.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring/spring-db.xml")
public class IAdminServiceTest {

	@Resource(name="adminService")
	private IAdminService adminService;
	
	@Test
	public void testLogin() {
		System.out.println(adminService.login("807824909@qq.com", "admin"));
	}

}
