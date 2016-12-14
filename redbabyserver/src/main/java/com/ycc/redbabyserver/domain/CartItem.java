package com.ycc.redbabyserver.domain;

public class CartItem {
	
	private int cart_id;
	private int product_id;
	private String prodNum;
	private String property_id;
	private Product product;
	
	public String getProperty_id() {
		return property_id;
	}
	public void setProperty_id(String propertyId) {
		property_id = propertyId;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cartId) {
		cart_id = cartId;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int productId) {
		product_id = productId;
	}
	public String getProdNum() {
		return prodNum;
	}
	public void setProdNum(String prodNum) {
		this.prodNum = prodNum;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
