package com.ycc.redbabyserver.domain;

public class Favorites {
	private int id;
	private String user_id;
	private String product_id;
	private int state;
	private long addtime;
	
	public long getAddtime() {
		return addtime;
	}
	public void setAddtime(long addtime) {
		this.addtime = addtime;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Favorites [id=" + id + ", user_id=" + user_id + ", product_id=" + product_id + ", state=" + state
				+ ", addtime=" + addtime + "]";
	}
	
}
