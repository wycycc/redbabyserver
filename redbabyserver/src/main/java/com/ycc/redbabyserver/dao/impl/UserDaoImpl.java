package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ycc.redbabyserver.dao.UserDao;
import com.ycc.redbabyserver.domain.Favorites;
import com.ycc.redbabyserver.domain.User;
import com.ycc.redbabyserver.domain.Version;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class UserDaoImpl implements UserDao {

	public void add(String username, String password) {
		String sql = "insert into user values(null,?,?,?,null,null,null,null,null,null,null)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, username, password, UUID.randomUUID().toString());
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from user where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public void update(String userid, String status) {
		String sql = "update user set status=? where userid=?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, status, userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public User findByUsername(String username) {
		String sql = "select * from user where username = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), username);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findByNameAndPsw(String username, String password) {
		String sql = "select * from user where username = ? and password = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), username, password);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User findByUserid(String userid) {
		String sql = "select * from user where userid = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<User>(User.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Favorites> findProidByUserid(String userid, String page, String pageNum) {
		int pageNow=(Integer.parseInt(page)-1)*(Integer.parseInt(pageNum));
		int pageCount=(Integer.parseInt(pageNum));
		String sql = "(select * from favorites where user_id = ? order by product_id desc limit ?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Favorites>(Favorites.class), userid,pageNow,pageCount);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public String getCount(String userid) {
		String sql = "select count(*) from favorites where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new ScalarHandler(), userid) + "";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Version> getVersion() {
		String sql = "select * from version";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Version>(Version.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addFavorite(String userid,String pId) {
		String sql = "insert into favorites values(null,?,?,?)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, userid, pId, 1);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String checkStatus(String username) {
		String sql = "select status from user where username = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new ScalarHandler(), username)+"";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
