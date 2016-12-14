package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Order;

public interface OrderDetailDao {
	/**
	 * 获取订单详情
	 * @param userid
	 * @param orderid
	 */
	Order getOrderById(String userid, String orderid);

}
