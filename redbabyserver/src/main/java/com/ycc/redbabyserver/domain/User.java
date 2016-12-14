package com.ycc.redbabyserver.domain;

import java.io.Serializable;

public class User implements Serializable {
	private int id;
	private String username;
	private String password;
	private String userid;
	private int bonus;
	private String level;
	private String usersession;
	private int ordercount;
	private int favoritescount;
	private int status;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getUsersession() {
		return usersession;
	}
	public void setUsersession(String usersession) {
		this.usersession = usersession;
	}
	public int getOrdercount() {
		return ordercount;
	}
	public void setOrdercount(int ordercount) {
		this.ordercount = ordercount;
	}
	public int getFavoritescount() {
		return favoritescount;
	}
	public void setFavoritescount(int favoritescount) {
		this.favoritescount = favoritescount;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", userid=" + userid
				+ ", bonus=" + bonus + ", level=" + level + ", usersession=" + usersession + ", ordercount="
				+ ordercount + ", favoritescount=" + favoritescount + ", status=" + status + ", state=" + state + "]";
	}

}
