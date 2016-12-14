package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.RecDao;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class RecDaoImpl implements RecDao {
	
	@Override
	public List<Object> find() {
		String sql = "select keywords from recommend";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return (List<Object>) runner.query(sql, new ColumnListHandler());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
