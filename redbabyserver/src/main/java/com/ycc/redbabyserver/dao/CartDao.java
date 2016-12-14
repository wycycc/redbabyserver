package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.domain.Cart1;

import java.util.List;
import java.util.Map;

public interface CartDao {
	
	Cart getCart();
	
	Cart1 findCartByUserId(String userId);
	
	/**
	 * 通过用户ID获取购物信息
	 * @param userid
	 * @return
	 */
	Cart findCartByUserid(String userid);

	/**
	 * 向购物车添加信息
	 * @param
	 * @param sku
	 */
	void addToCartItem(String cartid, String[] sku);

	/**
	 * 更新购物车信息
	 * @param userid
	 * @param strs
	 */
	void updateCartInfo(String userid, String[] strs, Cart cart);

	/**
	 * 获取购物车商品列表 - 对应cart模块需要的字段
	 * @return
	 */
	List<Map<String,Object>> getCartProList(String userId);

	/**
	 * 获取购买商品的属性
	 * @param userId
	 * @return
	 */
	List<Map<String, Object>> getProperty(String proId);
	
	/**
	 * 获取购买商品的属性字串
	 * @param userId
	 * @return
	 */
	String getPropertyString(String cartId, String proId);


	/**
	 * 删除购物车中指定商品
	 * @param userid 用户名 
	 * @param pId 商品Id
	 * @return 结果(影响行数)
	 */
	int deleteProd(String userid, String pId);

	/**
	 * 删除购物车中全部商品
	 * @return 结果(影响行数)
	 */
	int deleteAllProd(String userid);
	
	/**
	 * 获取商品数量
	 * @param userid 用户名
	 * @param strs 参数集合
	 * @return
	 */
	int getSingleProdNum(String userid, String[] strs);


	/**
	 * @param userid 用户名
	 * 注册时向购物车添加信息
	 */
	void addUserInfo(String userid);


	int deleteAllProd2(String userid);


	/**
	 * 更新购物车项信息
	 * @param userid 
	 * @param strs
	 */
	void updateCartItemInfo(String userid, String[] strs);


	/**
	 * 获取购物车id
	 * @param userid
	 * @return
	 */
	int findCartIdByUserid(String userid);	
}
