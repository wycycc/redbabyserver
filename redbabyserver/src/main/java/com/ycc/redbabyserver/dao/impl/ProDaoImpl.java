package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class ProDaoImpl implements ProDao {
	@Override
	public Product findById(String proid) {
		String sql = "select * from product where pro_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<Product>(Product.class), proid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findByKeyword(String keyword, String orderby, String pageNum, String page) {
		String sql = "select * from product where name like '%" + keyword + "%' order by ? desc limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), orderby, Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int getCount() {
		String sql = "select count(*) from product";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return Integer.parseInt(runner.query(sql, new ScalarHandler()) + "");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findByBrandId(String brand_id, String orderby, String pageNum, String page, String order) {
		String sql = "select * from product where brand_id = " + brand_id + " order by ? " + order
				+ " limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), orderby, Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findLimitbuy(String pageNum, String page) {
		String sql = "select * from product where lefttime is not null limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findNewProduct(String orderby, String pageNum, String page) {
		String sql = "select * from product order by shelvesTime desc limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findHotProduct(String orderby, String pageNum, String page) {
		String sql = "select * from product order by salesNum desc limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public List<Product> findByCateIdAndFilter(String cId, String orderby, String filter) {
		String sql = "select product.name " + "from product,filter,property "
				+ "where product.pro_id = filter.product_id and property.id = filter.property_id and cate_id = ? "
				+ filter + " group by product.pro_id order by " + orderby;
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), cId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public List<Product> findByCateId(String cId, String page, String pageNum, String orderby, String filter) {
		String sql = "select * from product where cate_id=? order by " + orderby + " limit ?,?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), cId, Integer.parseInt(page) - 1,
					Integer.parseInt(page) * Integer.parseInt(pageNum));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getCountByFilter(String cId, String filter) {
		String sql = "select count(*) from product where cate_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return String.valueOf(runner.query(sql, new ScalarHandler(), cId));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Product> findByTopicId(String topic_id, String orderby, String pageNum, String page, String order) {
		String sql = "select * from product where brand_id = " + topic_id + " order by ? " + order
				+ " limit ? offset ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Product>(Product.class), orderby, Integer.parseInt(pageNum),
					Integer.parseInt(page));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
