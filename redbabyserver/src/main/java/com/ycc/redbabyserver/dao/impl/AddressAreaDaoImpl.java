package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;

import com.ycc.redbabyserver.dao.AddressAreaDao;
import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class AddressAreaDaoImpl implements AddressAreaDao {

	@Override
	public AddressArea findAddrAreaByAreaId(String areaId) {
		String sql = "select * from addressarea where area_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<AddressArea>(AddressArea.class), areaId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}