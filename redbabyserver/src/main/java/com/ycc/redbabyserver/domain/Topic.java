package com.ycc.redbabyserver.domain;

public class Topic {
	private int id;
	private String title;
	private String pic;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Override
	public String toString() {
		return "Topic [id=" + id + ", title=" + title + ", pic=" + pic + ", state=" + state + "]";
	}
	
}
