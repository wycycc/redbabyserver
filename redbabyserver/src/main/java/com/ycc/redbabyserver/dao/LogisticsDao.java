package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Logistics;

public interface LogisticsDao {
	/**
	 * 根据订单Id获取物流信息
	 * @param orderId
	 * @return
	 */
	Logistics findLogistByOrderId(String orderId, String userid);
	
	/**
	 * 根据订单id插入数据，只要订单id是对的，其他数据本来就是卖家给的，可以写死
	 * @param orderUuid
	 * @return
	 */
	void insertLogistByOrderId(String orderUuid);
	
}
