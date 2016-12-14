package com.ycc.redbabyserver.dao;

import com.ycc.redbabyserver.domain.Order;

import java.util.List;

public interface OrderDao {

	/**
	 * 获取指定类型的订单信息
	 * @param type
	 * @param userid
	 * @param page
	 * @param pageNum
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
	 * 获取取消商品信息
	 * @param type
	 * @param userid
	 * @param page
	 * @param pageNum
	 * @param state
	 * @return
	 */
	List<Order> getOrderListByTypes(String type, String userid, String page, String pageNum, String state);

}
