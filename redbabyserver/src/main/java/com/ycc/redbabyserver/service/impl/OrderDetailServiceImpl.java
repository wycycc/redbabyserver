package com.ycc.redbabyserver.service.impl;


import java.util.ArrayList;
import java.util.List;

import com.ycc.redbabyserver.dao.AddressAreaDao;
import com.ycc.redbabyserver.dao.AddressDao;
import com.ycc.redbabyserver.dao.CartDao;
import com.ycc.redbabyserver.dao.CartItemDao;

import com.ycc.redbabyserver.dao.OrderDetailDao;

import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.domain.CartItem;
import com.ycc.redbabyserver.domain.Product;

import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.OrderDetailService;


public class OrderDetailServiceImpl implements OrderDetailService {
	OrderDetailDao orderDetailDao = BasicFactory.getInstance(OrderDetailDao.class);

	AddressDao addressDao = BasicFactory.getInstance(AddressDao.class);
	CartItemDao cartItemDao = BasicFactory.getInstance(CartItemDao.class);
	ProDao proDao = BasicFactory.getInstance(ProDao.class);
	CartDao cartDao = BasicFactory.getInstance(CartDao.class);
	AddressAreaDao addressAreaDao = BasicFactory.getInstance(AddressAreaDao.class);

	@Override
	public Order getOrderById(String userid, String orderid) {
		Order orderDetail = orderDetailDao.getOrderById(userid,orderid);
		System.out.println("orderDetail==null?"+orderDetail==null);
		List<Address> addressList = addressDao.findAddressByUserid(userid);
		if(addressList != null){
			for(Address address : addressList){
				if("0".equals(address.getIsdefault())){
					//addressAreaDao.findAddrAreaByAreaId(address)
					
					orderDetail.setAddress(address);
					break;
				}
			}
		}
		

//		List<CartItem> cartItemList = cartItemDao.findCartItemListByUserid(userid);
//		for(CartItem cartItem : cartItemList){
//			//proDao.findById(String.vacartItem.getProduct_id());
//		Cart cartList = cartDao.findCartByUserid(userid);
//		List<Product> productList = new ArrayList<Product>();
//		if(cartItemList != null){
//			for(CartItem cartItem1 : cartItemList){
//				Product product = proDao.findById(String.valueOf(cartItem1.getProduct_id()));
//				productList.add(product);
//				
//			}
//	
		Cart cartList = cartDao.findCartByUserid(userid);
		List<Product> productList = new ArrayList<Product>();
		List<CartItem> cartItemList = cartItemDao.findCartItemListByCartId(cartList.getId());
		if(cartItemList != null){
			for(CartItem cartItem : cartItemList){
				Product product = proDao.findById(String.valueOf(cartItem.getProduct_id()));
				productList.add(product);
				
			}
			
		}

		

		return orderDetail;

	}
}
