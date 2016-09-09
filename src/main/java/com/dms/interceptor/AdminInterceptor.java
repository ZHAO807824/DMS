package com.dms.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.dms.kit.AdminKit;
import com.dms.service.IAdminService;
import com.google.common.collect.Lists;

/**
 * 用户登录拦截器
 * 
 * @author zhao
 *
 */
public class AdminInterceptor implements HandlerInterceptor {

	// 默认拦截路径
	private List<String> urls = Lists.newArrayList();
	
	@Autowired
	private IAdminService adminService;

	/**
	 * 预处理回调方法
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 处理不拦截的资源
		String uri = request.getRequestURI();
		for (String url : urls) {
			if (uri.endsWith(url)) {
				return true;
			}
		}
		// 校验用户登录
		Cookie[] cookies = request.getCookies();
		if (cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				if ("auth".equals(cookie.getName())) {
					// 显式清除ThreadLocal
					if (adminService.check(cookie.getValue())) {
						return true;
					} else {
						AdminKit.remove();
						return false;
					}
				}
			}
		}
		return false;
	}

	/**
	 * 后处理回调方法
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 整个请求处理完毕回调方法
	 */
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	public List<String> getUrls() {
		return urls;
	}

	public void setUrls(List<String> urls) {
		this.urls = urls;
	}

}
