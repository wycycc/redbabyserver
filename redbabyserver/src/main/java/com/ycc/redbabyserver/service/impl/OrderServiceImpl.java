package com.ycc.redbabyserver.service.impl;

import java.util.List;

import com.ycc.redbabyserver.dao.OrderDao;
import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.OrderService;

public class OrderServiceImpl implements OrderService {
	OrderDao orderDao = BasicFactory.getInstance(OrderDao.class);
	@Override
	public List<Order> getOrderListByType(String type, String userid, String page, String pageNum) {
		return orderDao.getOrderListByType(type,userid,page,pageNum);
	
	}
	@Override
	public List<Order> deleteOrderById(String orderId,String userid) {
		return orderDao.deleteOrderById(orderId,userid);
	}
	@Override
	public int cancelOrderById(String orderId, String userid) {
		return orderDao.cancelOrderById(orderId, userid);
	}

	public List<Order> getOrderListByTypes(String type, String userid, String page, String pageNum) {
		String state = "1";
		if("3".equals(type)){
			state = "0";
		}
		return orderDao.getOrderListByTypes(type,userid,page,pageNum,state);
	
	}

}
