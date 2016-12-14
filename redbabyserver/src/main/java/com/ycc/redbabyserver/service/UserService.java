package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.domain.User;

import java.util.List;

public interface UserService {

	/**
	 * 用户登录
	 * 
	 * @param username
	 * @param password
	 */
	String login(String username, String password);

	/**
	 * 用户注册
	 * @param username
	 * @param password
	 * @return
	 */
	String register(String username, String password);
	/**
	 * 获取用户信息
	 * @param userid
	 * @return
	 */
	User getUserinfo(String userid);
	/**
	 * 用户注销
	 * @param userid
	 * @return 是否注销成功
	 */
	boolean Logout(String userid);
	/**
	 * 查询用户收藏夹
	 * @param userid
	 * @param page
	 * @param pageNum
	 * @return
	 */
	List<Product> getFavorites(String userid, String page, String pageNum);
	/**
	 * 获得收藏夹产品总数
	 * @param userid
	 * @return
	 */
	String getCount(String userid);

	/**
	 * 添加收藏
	 * @param userid 用户ID
	 * @param pId 商品ID
	 */
	void addFavorite(String userid, String pId);
}