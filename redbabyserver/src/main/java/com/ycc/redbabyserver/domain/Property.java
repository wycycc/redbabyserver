package com.ycc.redbabyserver.domain;

public class Property {
	private int id;
	private String key;
	private String value;
	private String product_id;
	
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String productId) {
		product_id = productId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", key=" + key + ", product_id=" + product_id + ", value=" + value + "]";
	}
	
	
	
	
}
