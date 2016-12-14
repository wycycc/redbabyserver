package com.ycc.redbabyserver.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ycc.redbabyserver.dao.CartDao;
import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.dao.UserDao;
import com.ycc.redbabyserver.domain.Favorites;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.domain.User;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDao userdao = BasicFactory.getInstance(UserDao.class);
	private ProDao prodao = BasicFactory.getInstance(ProDao.class);
	private CartDao cartdao = BasicFactory.getInstance(CartDao.class);

	public String register(String username, String password) {
		// 1.检查用户名是否已经存在
		if (userdao.findByUsername(username) != null) {
			throw new RuntimeException("用户名已经存在！！");
		}
		// 2.注册用户
		userdao.add(username, password);
		// 3.返回用户Id
		User user = userdao.findByUsername(username);
		if (user != null) {
			String getId = user.getUserid() + "";
			cartdao.addUserInfo(getId);
			return getId;
		}
		
		//向购物车添加信息
		return null;
	}

	public String login(String username, String password) {
		User user = userdao.findByNameAndPsw(username, password);
		if (user != null) {
			String userid = user.getUserid() + "";
			return userid;
		}
		return null;
	}

	@Override
	public User getUserinfo(String userid) {
		User user = userdao.findByUserid(userid);
		return user;
	}

	@Override
	public boolean Logout(String userid) {
		userdao.update(userid, "0");
		int status = userdao.findByUserid(userid).getStatus();
		return status == 0 ? true : false;
	}

	@Override
	public List<Product> getFavorites(String userid, String page, String pageNum) {
		// 通过userid查询对应的收藏夹proid
		List<Favorites> favorites = userdao.findProidByUserid(userid, page, pageNum);
		List<Product> list = new ArrayList<Product>();
		// 查询数目
		int Num = Integer.parseInt(page) * Integer.parseInt(pageNum);
		for (int i = 0; i < (favorites.size() < Num ? favorites.size() : Num); i++) {
			Product product = prodao.findById(favorites.get(i).getProduct_id());
			list.add(product);
		}
		return list;
	}

	@Override
	public String getCount(String userid) {
		return userdao.getCount(userid);
	}

	@Override
	public void addFavorite(String userid, String pId) {
		userdao.addFavorite(userid, pId);
	}
}