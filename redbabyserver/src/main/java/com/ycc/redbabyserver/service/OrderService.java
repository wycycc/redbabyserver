package com.ycc.redbabyserver.service;

import com.ycc.redbabyserver.domain.Order;

import java.util.List;

public interface OrderService {

	/**
	 * 获取订单
	 * 1=>近一个月订单 2=>一个月前订单 3=>已取消订单
	 * @return
	 */

	List<Order> getOrderListByType(String type, String userid, String page, String pageNum);
	
	/**
	 * 通过传递进来的orderId删除订单项
	 * @param orderId
	 * @param userid 
	 * @return
	 */
	List<Order> deleteOrderById(String orderId, String userid);

	/**
	 * 取消订单
	 * @param orderId
	 * @param userid
	 * @return
	 */
	int cancelOrderById(String orderId, String userid);
	
	/**
	 * 获取订单
	 * 1=>近一个月订单 2=>一个月前订单 3=>已取消订单
	 * @return
	 */
	public List<Order> getOrderListByTypes(String type, String userid, String page, String pageNum);
}
