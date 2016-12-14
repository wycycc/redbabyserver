package com.ycc.redbabyserver.domain;

public class Logistics {
	private int id;
	private String order_id;
	private String listaddr;
	private String expressway;
	private String logisticscorp;
	private String logisticsid;
	private int state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String orderId) {
		order_id = orderId;
	}
	public String getListaddr() {
		return listaddr;
	}
	public void setListaddr(String listaddr) {
		this.listaddr = listaddr;
	}
	public String getExpressway() {
		return expressway;
	}
	public void setExpressway(String expressway) {
		this.expressway = expressway;
	}
	public String getLogisticscorp() {
		return logisticscorp;
	}
	public void setLogisticscorp(String logisticscorp) {
		this.logisticscorp = logisticscorp;
	}
	public String getLogisticsid() {
		return logisticsid;
	}
	public void setLogisticsid(String logisticsid) {
		this.logisticsid = logisticsid;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
}
