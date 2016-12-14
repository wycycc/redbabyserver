package com.ycc.redbabyserver.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ycc.redbabyserver.dao.CartDao;
import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.domain.Cart1;
import com.ycc.redbabyserver.domain.CartItem;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.utils.DaoUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 购物车dao实现类
 * 
 * @author gaojing
 * 
 */
public class CartDaoImpl implements CartDao {
	private QueryRunner runner = new QueryRunner(DaoUtil.getSource());

	public Cart getCart(int cartId) {
		Cart cart = null;
		String sql = "select totalCount from cart where id=?";
		try {
			cart = runner.query(sql, new BeanHandler<Cart>(Cart.class), cartId);
			Product product = new Product();
			product.setId(1000);
			product.setName("dsgsgdsg");
			
			CartItem item = new CartItem();
			item.setProdNum("33");
			item.setProduct(product);
			
			CartItem item1 = new CartItem();
			item.setProdNum("33");
			item.setProduct(product);
			
			ArrayList list = new ArrayList();
			list.add(item);
			list.add(item1);
			
			cart.setCartItem(list);
			if (cart != null) {
				//fillCartItem(cart);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}


	@Override
	public Cart getCart() {
		return null;
	}
	
	
	public Cart1 findCartByUserId(String userId){
		String sql = "select * from cart where user_id = ? ";
		try {
			Cart1 cart = runner.query(sql, new BeanHandler<Cart1>(Cart1.class),userId);
			return cart;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cart findCartByUserid(String userid) {
		String sql = "select * from cart where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new BeanHandler<Cart>(Cart.class), userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public int findCartIdByUserid(String userid) {
		String sql = "select id from cart where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return Integer.valueOf((Integer) runner.query(sql, new ScalarHandler(), userid));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void addToCartItem(String cartid, String[] sku) {
		String sql = "insert into cartitem values(null,?,?,?,?,1)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, sku[0],cartid,sku[2].replace(",", "000"),sku[1]);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateCartInfo(String userid, String[] strs , Cart cart) {
		String sql = "update cart set totalCount = ?,totalPrice = ?,totalPoint = ? where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, cart.getTotalCount(), cart.getTotalPrice(),cart.getTotalPoint(),userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public void updateCartItemInfo(String userid, String[] strs) {
		String sql = "update cartitem set prodNum = ? where product_id = ? and property_id = ? and cart_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, strs[1], strs[0],strs[2],userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public List<Map<String,Object>> getCartProList(String userId) {
		String sql = "select pro_id as id,name,pic,price,proCount as number,isGift,sum(cartitem.prodNum) as prodNum,property_id " +
				"from cartitem,product " +
				"where cartitem.product_id = product.pro_id and cartitem.cart_id = ? group by product.pro_id,property_id";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new MapListHandler(), userId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public int getSingleProdNum(String userid, String[] strs) {
		String sql = "select sum(prodNum) " +
				"from cartitem " +
				"where cart_id = ? and product_id = ? and property_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return Integer.valueOf((String) runner.query(sql, new ScalarHandler(), userid,strs[0],strs[2]));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@Override
	@Deprecated
	public List<Map<String, Object>> getProperty(String proId) {
		String sql = "select property.key,property.value " +
				"from cartitem,property " +
				"where cartitem.property_id = property.id and cartitem.product_id = ? group by property.id";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.query(sql, new MapListHandler(), proId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public int deleteProd(String userid,String pId) {
		String sql = "delete from cartitem where cart_id = ? and product_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql, userid, pId);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteAllProd(String userid) {
		String sql = "delete from cartitem where cart_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	
	public int deleteAllProd2(String userid) {
		String sql = "update cart set totalCount = 0,totalPrice = 0,totalPoint = 0 where user_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return runner.update(sql,userid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	

	@Override
	public String getPropertyString(String cartId ,String proId) {
		String sql = "select property_id " +
				"from cartitem " +
				"where product_id = ? and cart_id = ?";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			return String.valueOf(runner.query(sql, new ScalarHandler(), proId,cartId));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}


	@Override
	public void addUserInfo(String userid) {
		String sql = "insert into cart values(null,?,?,?,?,1)";
		try {
			QueryRunner runner = new QueryRunner(DaoUtil.getSource());
			runner.update(sql, 0, userid, 0, 0);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
