package com.ycc.redbabyserver.domain;

import java.util.List;

public class Cart {
	private List<CartItem> cartItem;
	private int id;
	private String user_id;
	private String totalCount;
	private String totalPoint;
	private String totalPrice;
//	private int state;
	
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String userId) {
		user_id = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getTotalPoint() {
		return totalPoint;
	}

	public void setTotalPoint(String totalPoint) {
		this.totalPoint = totalPoint;
	}

	public List<CartItem> getCartItem() {
		return cartItem;
	}

	public void setCartItem(List<CartItem> cartItem) {
		this.cartItem = cartItem;
	}


//	public int getState() {
//		return state;
//	}
//
//	public void setState(int state) {
//		this.state = state;
//	}

}
