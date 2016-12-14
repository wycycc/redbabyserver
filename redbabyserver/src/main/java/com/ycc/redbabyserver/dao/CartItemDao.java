package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.CartItem;

import java.util.List;

public interface CartItemDao {
	/**
	 * 通过购物表id获取对应的购物项
	 * @param id
	 * @return
	 */
	List<CartItem> findCartItemListByCartId(int id);
	/**
	 * 通过用户id获取对应的购物项
	 * @param user_id
	 * @return
	 */
	List<CartItem> findCartItemListByUserId(String user_id);
	
	
}
