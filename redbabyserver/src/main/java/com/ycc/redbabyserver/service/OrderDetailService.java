package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Order;

import java.util.List;

public interface OrderDetailService {
	/**
	 * 获取商品详情
	 * @param userid
	 * @param orderid
	 * @return
	 */
	Order getOrderById(String userid, String orderid);

}
