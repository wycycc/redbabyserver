package com.ycc.redbabyserver.domain;

/**
 * 地址
 * 
 * @author Administrator
 * 
 */
public class Address {
	private int id;
	private String address_id;
	private String name;
	private String phonenumber;
	private String fixedtel;
	private String provinceid;
	private String cityid;
	private String area_id;
	private String areaDetail;
	private String zipCode;
	private String isdefault;
	private String user_id;
	private int state;
	//仅仅用来保存数据用的
	private String address_area;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress_id() {
		return address_id;
	}

	public void setAddress_id(String address_id) {
		this.address_id = address_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFixedtel() {
		return fixedtel;
	}

	public void setFixedtel(String fixedtel) {
		this.fixedtel = fixedtel;
	}

	public String getProvinceid() {
		return provinceid;
	}

	public void setProvinceid(String provinceid) {
		this.provinceid = provinceid;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}

	public String getAreaDetail() {
		return areaDetail;
	}

	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getIsdefault() {
		return isdefault;
	}

	public void setIsdefault(String isdefault) {
		this.isdefault = isdefault;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
	public String getAddress_area() {
		return address_area;
	}

	public void setAddress_area(String addressArea) {
		address_area = addressArea;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", address_id=" + address_id + ", name=" + name + ", phonenumber=" + phonenumber
				+ ", fixedtel=" + fixedtel + ", provinceid=" + provinceid + ", cityid=" + cityid + ", area_id="
				+ area_id + ", areaDetail=" + areaDetail + ", zipCode=" + zipCode + ", isdefault=" + isdefault
				+ ", user_id=" + user_id + ", state=" + state + "]";
	}
	
}
