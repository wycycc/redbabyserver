package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Product;

import java.util.List;

public interface ProDao {
	/**
	 * 根据proid查询对应产品信息
	 * @param proid
	 * @return
	 */
	Product findById(String proid);

	/**
	 * 根据keyword查询产品信息
	 * @param keyword
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> findByKeyword(String keyword, String orderby, String pageNum, String page);

	/**
	 * 获取产品总数
	 * @return
	 */
	int getCount();
	/**
	 * 根据品牌id查询产品
	 * @param brand_id
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> findByBrandId(String brand_id, String orderby, String pageNum, String page, String order);
	/**
	 * 查询指定页数的限时商品
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> findLimitbuy(String pageNum, String page);
	/**
	 * 查询指定页数的新商品
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> findNewProduct(String orderby, String pageNum, String page);
	/**
	 * 查询指定页数的热门商品
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> findHotProduct(String orderby, String pageNum, String page);
	
	/**
	 * 根据分类获取商品列表
	 * @param cId 分类ID
	 * @param page 页码
	 * @param pageNum 每页数量
	 * @param orderby 排序
	 * @param filter 
	 * @return
	 */
	List<Product> findByCateId(String cId, String page, String pageNum, String orderby, String filter);
	
	/**
	 * 根据分类和筛选获取商品列表
	 * @param cId
	 * @param orderby
	 * @param filter
	 * @return
	 */
	List<Product> findByCateIdAndFilter(String cId, String orderby, String filter);

	/**
	 * 获取列表商品总数
	 * @param cId
	 * @param filter
	 * @return
	 */
	String getCountByFilter(String cId, String filter);
	/**
	 * 根据专题id获取商品列表
	 * @param topic_id
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @param order
	 * @return
	 */
	List<Product> findByTopicId(String topic_id, String orderby, String pageNum, String page, String order);
}
