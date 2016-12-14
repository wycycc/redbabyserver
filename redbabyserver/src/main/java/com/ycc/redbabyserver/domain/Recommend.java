package com.ycc.redbabyserver.domain;

public class Recommend {
	private int id;
	private String keywords;
	private int state;
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	@Override
	public String toString() {
		return "Recommend [id=" + id + ", keywords=" + keywords + ", state=" + state + "]";
	}
	
}
