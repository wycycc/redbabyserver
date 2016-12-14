package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Property;

import java.util.List;

public interface PropertyService {
	
	/**
	 * 根据product_id获得属性的集合
	 * @return
	 */
	List<Property> findAllPropertyById(int id);
	
}
