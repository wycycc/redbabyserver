package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.ycc.redbabyserver.dao.CartItemDao;
import com.ycc.redbabyserver.domain.CartItem;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CartItemDaoImpl implements CartItemDao {

	@Override
	public List<CartItem> findCartItemListByCartId(int id) {
		String sql = "select * from cartitem where cart_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<CartItem>(CartItem.class), id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<CartItem> findCartItemListByUserId(String user_id) {
		String sql = "select * from cartitem where cart_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<CartItem>(CartItem.class), user_id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
