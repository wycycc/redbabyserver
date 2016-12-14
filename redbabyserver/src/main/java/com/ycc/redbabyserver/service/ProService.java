package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Product;

import java.util.List;

public interface ProService {
	/**
	 * 产品列表
	 * @param keyword
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> getProductlist(String keyword, String orderby, String pageNum, String page);
	
	
	/**
	 * 分类产品列表
	 * @param filter 
	 * @param orderby 
	 * @param pageNum 
	 * @param page 
	 * @param cId 
	 * @return
	 */
	List<Product> getCateProductlist(String cId, String page, String pageNum, String orderby, String filter);

	/**
	 * 获取产品总数
	 * 
	 * @return
	 */
	int getCount();
	/**
	 * 通过专题id获取商品列表
	 * @param top_id 专题id
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> getTopicPList(String top_id, String orderby, String pageNum, String page, String order);
	/**
	 * 通过品牌id获取商品列表
	 * @param brand_id 品牌id
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> getBrandPList(String brand_id, String orderby, String pageNum, String page, String order);
	/**
	 * 查询所有限时商品
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> getLimitbuy(String pageNum, String page);
	/**
	 * 查询指定数目的新上架商品
	 * @param orderby
	 * @param pageNum
	 * @param page
	 * @return
	 */
	List<Product> getNewProduct(String orderby, String pageNum, String page);


	/**
	 * 通过pro_id查找商品
	 * @param pro_id
	 * @return 
	 */
	Product findProById(String pro_id);


	/**
	 * 通过条件查询总数
	 * @param filter 
	 * @return
	 */
	String getCountByFilter(String cId, String filter);

}
