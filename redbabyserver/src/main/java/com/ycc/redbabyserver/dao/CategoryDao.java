package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Category;

import java.util.List;

public interface CategoryDao {
	/**
	 * 获取全部分类信息
	 * @return
	 */

	List<Category> findAll();

	/**
	 * 获取最新版本
	 * @return
	 */
	String getLastVersion();

}
