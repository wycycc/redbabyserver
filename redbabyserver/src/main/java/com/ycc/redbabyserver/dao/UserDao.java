package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Favorites;
import com.ycc.redbabyserver.domain.User;
import com.ycc.redbabyserver.domain.Version;

import java.util.List;

public interface UserDao {
	/**
	 * 添加客户
	 * @param
	 */
	void add(String username, String password);

	/**
	 * 删除用户
	 * @param id
	 */
	void delete(int id);

	/**
	 * 根据用户名查找用户
	 * @param username
	 * @return
	 */
	User findByUsername(String username);

	/**
	 * 根据用户名密码查找用户
	 * @param username
	 * @param password
	 * @return
	 */
	User findByNameAndPsw(String username, String password);
	/**
	 * 根据用户userid查找用户
	 * @param userid
	 * @return 用户bean
	 */
	User findByUserid(String userid);
	/**
	 * 更新用户的登录状态
	 */
	void update(String userid, String status);
	/**
	 * 通过userid查询指定数目的proid 
	 * @param userid
	 * @param page
	 * @param pageNum
	 * @return
	 */
	List<Favorites> findProidByUserid(String userid, String page, String pageNum);
	/**
	 * 查询收藏夹产品总数
	 * @param userid
	 * @return
	 */
	String getCount(String userid);
	/**
	 * 获取版本信息
	 * @return
	 */
	List<Version> getVersion();

	/**
	 * 添加收藏
	 * @param pId 
	 * @param userid 
	 */
	void addFavorite(String userid, String pId);
	/**
	 * 获取用户登录状态码
	 * @param username
	 * @return
	 */
	String checkStatus(String username);

}
