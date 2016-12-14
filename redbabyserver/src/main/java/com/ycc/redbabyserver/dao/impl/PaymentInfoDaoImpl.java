package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.domain.PaymentInfo;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class PaymentInfoDaoImpl {
	public List<PaymentInfo> findAll(){
		String sql = "select * from paymentinfo";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<PaymentInfo>(PaymentInfo.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
