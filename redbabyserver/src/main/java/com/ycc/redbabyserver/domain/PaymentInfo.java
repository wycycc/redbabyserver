package com.ycc.redbabyserver.domain;

public class PaymentInfo {
	private int id;
	private String code;
	private String paytype;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}

