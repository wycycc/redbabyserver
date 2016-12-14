package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.PropertyDao;
import com.ycc.redbabyserver.domain.Property;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


public class PropertyDaoImpl implements PropertyDao {

	@Override
	public List<Property> findAllPropertyById(int id) {
		String sql = "select * from filter,property where filter.property_id = property.id and product_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Property>(Property.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

	@Override
	public Property getPropertyById(String property_id) {
		String sql = "select * from property where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<Property>(Property.class), property_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

}
