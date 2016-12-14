package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Brand;

import java.util.List;

public interface BrandDao {
	/**
	 * 查询所有的推荐品牌
	 * @return
	 */
	List<Brand> getBrand();
	/**
	 * 根据key查询对应的品牌信息
	 * @param key
	 * @return
	 */
	List<Brand> getBrandByKey(String key);
	
}
