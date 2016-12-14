package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;

import com.ycc.redbabyserver.dao.OrderDetailDao;
import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class OrderDetailDaoImpl implements OrderDetailDao {
	@Override
	public Order getOrderById(String userid, String orderid) {
		String sql = "SELECT * FROM `order` WHERE order_uuid = ? AND userid = ?;";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<Order>(Order.class),orderid,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
