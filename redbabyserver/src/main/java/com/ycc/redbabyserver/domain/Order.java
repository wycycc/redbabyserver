package com.ycc.redbabyserver.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int id;
	private String order_uuid;
	private String type;
	private String status;
	private String time;
	private String flag;
	private String price;
	private String payment_info_code;
	private String delivery_info_code;
	private String total_count;
	private String total_point;
	private String freight;
	private String prom_cut;
	private String total_price;
	private String invoicetitle;
	private String invoicecontent;
	private String invoicetype;
	private String userid;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getInvoicetype() {
		return invoicetype;
	}
	public void setInvoicetype(String invoicetype) {
		this.invoicetype = invoicetype;
	}
	private Address address ;
	
	private PaymentInfo paymentInfo = new PaymentInfo();
	private Logistics logistics = new Logistics();
	private List<Product> productList;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrder_uuid() {
		return order_uuid;
	}
	public void setOrder_uuid(String orderUuid) {
		order_uuid = orderUuid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}

	public String getPayment_info_code() {
		return payment_info_code;
	}
	public void setPayment_info_code(String paymentInfoCode) {
		payment_info_code = paymentInfoCode;
	}
	public String getDelivery_info_code() {
		return delivery_info_code;
	}
	public void setDelivery_info_code(String deliveryInfoCode) {
		delivery_info_code = deliveryInfoCode;
	}
	public String getTotal_count() {
		return total_count;
	}
	public void setTotal_count(String totalCount) {
		total_count = totalCount;
	}
	public String getTotal_point() {
		return total_point;
	}
	public void setTotal_point(String totalPoint) {
		total_point = totalPoint;
	}
	public String getFreight() {
		return freight;
	}
	public void setFreight(String freight) {
		this.freight = freight;
	}
	public String getProm_cut() {
		return prom_cut;
	}
	public void setProm_cut(String promCut) {
		prom_cut = promCut;
	}
	public String getTotal_price() {
		return total_price;
	}
	public void setTotal_price(String totalPrice) {
		total_price = totalPrice;
	}

	public String getInvoicetitle() {
		return invoicetitle;
	}
	public void setInvoicetitle(String invoicetitle) {
		this.invoicetitle = invoicetitle;
	}
	public String getInvoicecontent() {
		return invoicecontent;
	}
	public void setInvoicecontent(String invoicecontent) {
		this.invoicecontent = invoicecontent;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public Address getAddress() {
		return address;
	}
	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}
	public Logistics getLogistics() {
		return logistics;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
}
