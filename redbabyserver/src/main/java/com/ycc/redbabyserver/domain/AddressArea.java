package com.ycc.redbabyserver.domain;

public class AddressArea {
	private int id;
	private String area_id;
	private String area;
	private int state;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "AddressArea [id=" + id + ", area_id=" + area_id + ", area=" + area + ", state=" + state + "]";
	}

}
