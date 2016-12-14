package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.CartItemDao;
import com.ycc.redbabyserver.domain.CartItem;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	CartItemDao cartItemDao = BasicFactory.getInstance(CartItemDao.class);
	@Override
	public List<CartItem> findCartItemListByCartId(int id) {
		return cartItemDao.findCartItemListByCartId(id);
	}
	@Override
	public List<CartItem> findCartItemListByUserId(String user_id) {
		return cartItemDao.findCartItemListByUserId(user_id);
	}

}
