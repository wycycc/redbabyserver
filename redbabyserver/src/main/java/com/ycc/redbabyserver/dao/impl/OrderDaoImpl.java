package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ycc.redbabyserver.dao.OrderDao;
import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class OrderDaoImpl implements OrderDao {

	@Override
	public List<Order> getOrderListByType(String type, String userid, String page, String pageNum) {
		String sql = "SELECT * FROM `order` WHERE `type` = ? AND userid = ? ORDER BY id DESC limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),type,userid,Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	public void insertOrder(Order order) {
		String sql = "insert into `order` values (null,?,?,?,null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			
			runner.update(sql, order.getOrder_uuid(), order.getType(),order.getStatus(),order.getPrice(),order.getFlag(),order.getPayment_info_code(),order.getDelivery_info_code(),order.getTotal_count(),order.getTotal_point(),order.getFreight(),
					order.getProm_cut(),order.getTotal_price(),order.getInvoicetitle(),order.getInvoicecontent(),order.getUserid(),order.getState(),order.getInvoicetype());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public List<Order> deleteOrderById(String orderId,String userid) {
		String sql = "Select * FROM `order` WHERE state = 0 AND order_uuid = ? AND userid = ? limit 0,10";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),orderId,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int cancelOrderById(String orderId,String userid) {
		String sql = "UPDATE  `order` SET state = '0',`type` = '3' WHERE order_uuid = ? AND userid = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql, orderId,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public List<Order> getOrderListByTypes(String type, String userid, String page, String pageNum, String state) {
		String sql = "SELECT * FROM `order` WHERE state = ?  AND `type` = ? AND userid = ? ORDER BY `id` DESC limit ? offset ?";
		//System.out.println(sql);
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Order>(Order.class),Integer.parseInt(state),type,userid,Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
