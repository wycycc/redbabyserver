package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.ycc.redbabyserver.dao.AddressDao;
import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class AddressDaoImpl implements AddressDao {

	@Override
	public List<Address> findAddressByUserid(String userid) {
		String sql = "select * from address where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<Address>(Address.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<AddressArea> findAllArea() {
		String sql = "select * from addressarea";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<AddressArea>(AddressArea.class));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<AddressArea> findAreaByAreaid(String areaid) {
		String sql = "select * from addressarea where area_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanListHandler<AddressArea>(AddressArea.class), areaid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String insert(String userid, String name, String phonenumber, String areadetail) {
		String sql = "insert into address values(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			String address_id = UUID.randomUUID().toString();
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			int i = runner.update(sql, address_id, name, phonenumber, null, null, null, null,
					areadetail,null,null, userid, 1);
			if (i == 1) {
				return address_id;
			}
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public boolean update(String userid, String addressid, String name, String phonenumber, String areadetail) {
		String sql = "update address set user_id=?,name=?,phonenumber=?,fixedtel=?,provinceid=?,cityid=?,area_id=?,areadetail=?,zipcode=? where address_id =?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			int i = runner.update(sql, userid, name, phonenumber, null, null, null, null, areadetail,
					null, addressid);
			if (i == 1) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public String findIdByAddressId(String addressid) {
		String sql = "select id from address where address_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new ScalarHandler(), addressid) + "";
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateDefault(String addressid) {
		String sql = "update address set isdefault = 1 where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql, addressid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int delete(String addressid) {
		String sql = "delete from address where id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql, addressid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
