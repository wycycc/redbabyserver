package com.ycc.redbabyserver.service.impl;

import com.ycc.redbabyserver.dao.LogisticsDao;
import com.ycc.redbabyserver.dao.OrderDao;
import com.ycc.redbabyserver.domain.Logistics;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.LogisticsService;

public class LogisticsServiceImpl implements LogisticsService {
	LogisticsDao logisticsDao = BasicFactory.getInstance(LogisticsDao.class);
	@Override
	public Logistics findLogistByOrderId(String orderId,String userid) {
		return logisticsDao.findLogistByOrderId(orderId,userid);
	}
	@Override
	public void insertLogistics(String orderUuid) {
		logisticsDao.insertLogistByOrderId(orderUuid);
	}

}
