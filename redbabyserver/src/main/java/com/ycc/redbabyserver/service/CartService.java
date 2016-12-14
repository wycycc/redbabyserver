package com.ycc.redbabyserver.service;

import java.util.List;
import java.util.Map;

import  com.ycc.redbabyserver.domain.Cart;
import  com.ycc.redbabyserver.domain.Category;
import  com.ycc.redbabyserver.domain.Product;

public interface CartService {
	
	/**
	 * 通过用户id获取购物表
	 * @param userid
	 */
	Cart findCartByUserid(String userid);

	/**
	 * 向购物车添加商品
	 * @param
	 */
	void addToCart(String userid, String[] strs);

	/**
	 * 获取购物车中商品列表
	 */
	List<Map<String,Object>> getCartProList(String userId);

	/**
	 * 删除购物车中指定商品
	 * @param pId 商品Id
	 * @return 结果(影响行数)
	 */
	int deleteProd(String userid, String pId);
	
	/**
	 * 获取商品属性信息
	 * @param userid
	 * @param pId
	 * @return
	 */
	List<Map<String,Object>> getCartProdProperties(String userid, String pId);

	/**
	 * 修改商品数量
	 * @param userid 用户ID
	 * @param sku 修改参数
	 * @return
	 */
	void updateCart(String userid, String[] strs);

	int findCartIdByUserid(String userid);

}
