package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Logistics;

public interface LogisticsService {
	/**
	 * 根据订单Id获取物流信息
	 * @param orderId
	 * @return
	 */
	Logistics findLogistByOrderId(String orderId, String userid);
	
	/**
	 * 根据订单uuid插入物流信息，只要订单id是对的，其他数据本来就是卖家给的，可以写死
	 * @param orderUuid
	 */
	void insertLogistics(String orderUuid);

}
