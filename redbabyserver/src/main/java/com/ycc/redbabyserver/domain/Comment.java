package com.ycc.redbabyserver.domain;

import java.sql.Timestamp;

public class Comment {
	private int id;
	private String title;
	private String content;
	private String username;
	private String pri_id;
	private String state;
	private Timestamp time;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPri_id() {
		return pri_id;
	}
	public void setPri_id(String pri_id) {
		this.pri_id = pri_id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Timestamp getTime() {
		return time;
	}
	public void setTime(Timestamp time) {
		this.time = time;
	}
	
	
}
