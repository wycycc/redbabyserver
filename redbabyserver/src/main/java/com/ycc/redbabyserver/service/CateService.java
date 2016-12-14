package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Category;

import java.util.List;
import java.util.Map;

public interface CateService {

	/**
	 * 获取全部分类信息
	 * @return
	 */
	List<Category> getCateInfo();

	/**
	 * 获取版本号信息
	 * @return
	 */
	String getLastVersion();
}
