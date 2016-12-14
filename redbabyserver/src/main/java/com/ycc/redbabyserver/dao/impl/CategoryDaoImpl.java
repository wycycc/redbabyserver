package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.CategoryDao;
import com.ycc.redbabyserver.domain.Category;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CategoryDaoImpl implements CategoryDao {

	@Override
	public List<Category> findAll() {
			String sql = "select * from category";
			try {
				QueryRunner runner = new QueryRunner(DaoUtil.getSource());
				return runner.query(sql, new BeanListHandler<Category>(Category.class));
			} catch (SQLException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
	}

	@Override
	public String getLastVersion() {
		String sql = "select version from category order by version desc";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			Object[] objs = runner.query(sql, new ArrayHandler());
			if(objs != null && objs.length != 0){
				return (String) objs[0];
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return null;
	}
}
