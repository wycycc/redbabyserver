package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.CartItem;

import java.util.List;

public interface CartItemService {
	/**
	 * 根据 “购物表id” 获取 “购物表项” 的数据
	 * @param id
	 * @return
	 */
	List<CartItem> findCartItemListByCartId(int id);
	/**
	 * 根据 “用户id” 获取 “购物表项” 的数据
	 * @param
	 * @return
	 */
	List<CartItem> findCartItemListByUserId(String user_id);

}
