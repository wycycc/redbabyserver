package com.ycc.redbabyserver.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ycc.redbabyserver.service.CartService;
import org.apache.commons.lang.StringUtils;

import com.ycc.redbabyserver.dao.CartDao;
import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.dao.PropertyDao;
import com.ycc.redbabyserver.domain.Cart;
import com.ycc.redbabyserver.domain.Property;
import com.ycc.redbabyserver.factory.BasicFactory;

public class CartServiceImpl implements CartService {
	
	CartDao cartDao = BasicFactory.getInstance(CartDao.class);
	ProDao proDao = BasicFactory.getInstance(ProDao.class);
	PropertyDao properDao = BasicFactory.getInstance(PropertyDao.class);

	@Override
	public Cart findCartByUserid(String userid) {
		return cartDao.findCartByUserid(userid);
	}

	//计算总数的方法
	private void makeTotalData(String userid) {
		List<Map<String,Object>> list = cartDao.getCartProList(userid);
		int totalCount = 0;
		int totalPrice = 0;
		int totalPoint = 0;
		
		for(Map<String,Object> product:list){
			String prodNum = product.get("prodNum") + "";
			totalCount += Integer.valueOf(prodNum);
			totalPrice += Integer.valueOf(prodNum)*Integer.valueOf((String) product.get("price"));
			totalPoint += Integer.valueOf(prodNum)*2;
		}
		
		Cart cart = new Cart();
		cart.setTotalCount(String.valueOf(totalCount));
		cart.setTotalPrice(String.valueOf(totalPrice));
		cart.setTotalPoint(String.valueOf(totalPoint));
		
		cartDao.updateCartInfo(userid, null, cart);
	}
	
	@Override
	public void addToCart(String userid,String[] strs) {
		/*
			Cart cart = cartDao.findCartByUserid(userid);
			
			//价格
			String singlePrice = proDao.findById(strs[0]).getPrice();
			int newTotalPrice = Integer.valueOf(singlePrice)*Integer.valueOf(strs[1]) + Integer.valueOf(cart.getTotalPrice());
			newTotalPrice = newTotalPrice<0?0:newTotalPrice;
			cart.setTotalPrice(String.valueOf(newTotalPrice));
			
			//数量
			int newTotalCount = Integer.valueOf(strs[1]) + Integer.valueOf(cart.getTotalCount());
			newTotalCount = newTotalCount<0?0:newTotalCount;
			cart.setTotalCount(String.valueOf(newTotalCount));
			
			//Point积分
			int newTotalPoint = Integer.valueOf(cart.getTotalCount()) + 1;
			cart.setTotalPoint(String.valueOf(newTotalPoint));
			
			//修改cart信息
			cartDao.updateCartInfo(userid,strs,cart);
		*/
		
		//修改cartitem信息
		cartDao.addToCartItem(userid,strs);
		//修改cart信息
		makeTotalData(userid);
	}

	@Override
	public void updateCart(String userid, String[] strs) {
		//修改购物车项
		cartDao.updateCartItemInfo(userid, strs);
		//修改cart信息
		makeTotalData(userid);
	}
	
	@Override
	public List<Map<String,Object>> getCartProList(String userId) {
		List<Map<String,Object>> list = cartDao.getCartProList(userId);
		if(list != null && list.size() != 0){
			List<Map<String,Object>> cartitemList= new ArrayList<Map<String,Object>>();
			Map<String,Object> productMap = null;
			
			for(Map<String,Object> product:list){
				productMap = new HashMap<String, Object>();
				
				productMap.put("prodNum", product.get("prodNum"));
				product.remove("prodNum");
				product.put("uplimit", "10");
				
				String propertyString = String.valueOf(product.get("property_id"));
				product.remove("property_id");
				product.put("product_property", getCartProdProperties0(propertyString));

				productMap.put("product", product);
				
				cartitemList.add(productMap);
				productMap = null;
			}
			return cartitemList;
		}else{
			return null;
		}
	}
	
	
	//获取已购买商品属性
	public List<Map<String,Object>> getCartProdProperties(String cartId,String pId){
		String propertyString = cartDao.getPropertyString(cartId, pId);
		return getCartProdProperties0(propertyString);
	}
	
	private List<Map<String,Object>> getCartProdProperties0(String propertyString){
		System.out.println(propertyString);
		List<Map<String,Object>> properties = new ArrayList<Map<String,Object>>();
		Map<String,Object> property = null;
		
		String[] strs = propertyString.split("000");
		if(strs != null && strs.length != 0){
			for(String str: strs){
				System.out.println(str);
				property = new HashMap<String,Object>();
				Property pro = properDao.getPropertyById(str);
				System.out.println(pro==null);
				//通过属性ID获取属性存入List
				property.put("key", pro.getKey());
				property.put("value", pro.getValue());
				properties.add(property);
				property = null;
			}
		}	
		
		return properties;
	}
	

	
	@Override
	public int deleteProd(String userid,String pId) {
		//删除全部
		if(StringUtils.isBlank(pId)){
			List<Map<String,Object>> list = cartDao.getCartProList(userid);
			if(list != null && list.size() != 0){
				int result = cartDao.deleteAllProd(userid);
				if(result == 0)
					return 0;
				return cartDao.deleteAllProd2(userid);
			}else{
				cartDao.deleteAllProd2(userid);
				return 1;
			}
		}else{
		//Cart cart = cartDao.findCartByUserid(userid);
		
		//修改cart里的统计数字
		//价格
		/*String singlePrice = proDao.findById(pId).getPrice();
		int newTotalPrice = Integer.valueOf(singlePrice)*Integer.valueOf(strs[1]) + Integer.valueOf(cart.getTotalPrice());
		newTotalPrice = newTotalPrice<0?0:newTotalPrice;
		cart.setTotalPrice(String.valueOf(newTotalPrice));
		
		//数量
		int newTotalCount = Integer.valueOf(strs[1]) + Integer.valueOf(cart.getTotalCount());
		newTotalCount = newTotalCount<0?0:newTotalCount;
		cart.setTotalCount(String.valueOf(newTotalCount));
		
		//Point积分
		int newTotalPoint = Integer.valueOf(cart.getTotalCount()) + 1;
		cart.setTotalPoint(String.valueOf(newTotalPoint));
		
		//修改cart信息
		cartDao.updateCartInfo(userid,strs,cart);*/
		
			return cartDao.deleteProd(userid,pId);
		}
	}

	@Override
	public int findCartIdByUserid(String userid) {
		return cartDao.findCartIdByUserid(userid);
	}

}
