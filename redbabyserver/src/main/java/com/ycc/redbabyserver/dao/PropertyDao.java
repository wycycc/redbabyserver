package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Property;

import java.util.List;

public interface PropertyDao {
	
	/**
	 * 根据用商品id查询商品的全部属性
	 */
	List<Property> findAllPropertyById(int id);
	
	/**
	 * 根据ID查找单个属性
	 * @param str
	 * @return
	 */
	Property getPropertyById(String str);
}
