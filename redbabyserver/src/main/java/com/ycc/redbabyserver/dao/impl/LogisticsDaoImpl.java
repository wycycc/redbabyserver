package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;

import com.ycc.redbabyserver.dao.LogisticsDao;
import com.ycc.redbabyserver.domain.Logistics;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class LogisticsDaoImpl implements LogisticsDao {

	@Override
	public Logistics findLogistByOrderId(String orderId, String userid) {
		String sql = "SELECT * FROM logistics WHERE order_id = ? AND userid = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<Logistics>(Logistics.class),orderId,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void insertLogistByOrderId(String orderUuid) {
		String sql = "INSERT INTO logistics VALUES(NULL,?,'北京','快递','顺丰','test5',1,'30505')";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, orderUuid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
