package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.domain.DeliveryInfo;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class DeliveryInfoDaoImpl {
	public List<DeliveryInfo> findAll(){
		String sql = "select * from deliveryinfo";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<DeliveryInfo>(DeliveryInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
