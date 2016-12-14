package com.ycc.redbabyserver.domain;

import java.util.List;

public class Product {
	private int id;
	private String name;
	private String pro_id;
	private String pic;
	private String marketPrice;
	private String price;
	private String limitPrice;
	private String score;
	private String available;
	private String buyLimit;
	private String productProm;
	//private String[] productprom_array;
	private String inventoryArea;
	private String bigPic;
	private String shelvesTime;
	private String salesNum; //销量
	private String proCount;	//库存
	private String leftTime;
	private String isgift;

	private String cate_id;
	private String brand_id;

	private String topic_id;
	private String isGift;
	private String isNew;
	private String isHot;
	private String commentCount;

	private String description;
	private List<Property> properties;
	private int state;
	public List<Property> getProperties() {
		return properties;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPro_id() {
		return pro_id;
	}
	public void setPro_id(String pro_id) {
		this.pro_id = pro_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public String getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(String topic_id) {
		this.topic_id = topic_id;
	}
	public String getIsGift() {
		return isGift;
	}
	public void setIsGift(String isGift) {
		this.isGift = isGift;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	public String getBuyLimit() {
		return buyLimit;
	}
	public void setBuyLimit(String buyLimit) {
		this.buyLimit = buyLimit;
	}
	public String getMarketPrice() {
		return marketPrice;
	}
	public void setMarketPrice(String marketPrice) {
		this.marketPrice = marketPrice;
	}
	public String getLimitPrice() {
		return limitPrice;
	}
	public void setLimitPrice(String limitPrice) {
		this.limitPrice = limitPrice;
	}
	public String getProductProm() {
		return productProm;
	}
	public void setProductProm(String productProm) {
		this.productProm = productProm;
	}
	public String getInventoryArea() {
		return inventoryArea;
	}
	public void setInventoryArea(String inventoryArea) {
		this.inventoryArea = inventoryArea;
	}
	public String getBigPic() {
		return bigPic;
	}
	public void setBigPic(String bigPic) {
		this.bigPic = bigPic;
	}
	public String getShelvesTime() {
		return shelvesTime;
	}
	public void setShelvesTime(String shelvesTime) {
		this.shelvesTime = shelvesTime;
	}
	public String getSalesNum() {
		return salesNum;
	}
	public void setSalesNum(String salesNum) {
		this.salesNum = salesNum;
	}
	public String getLeftTime() {
		return leftTime;
	}
	public void setLeftTime(String leftTime) {
		this.leftTime = leftTime;
	}
	public String getCate_id() {
		return cate_id;
	}
	public void setCate_id(String cate_id) {
		this.cate_id = cate_id;
	}
	public String getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(String brand_id) {
		this.brand_id = brand_id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getIsNew() {
		return isNew;
	}
	public void setIsNew(String isNew) {
		this.isNew = isNew;
	}
	public String getIsHot() {
		return isHot;
	}
	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getProCount() {
		return proCount;
	}
	public void setProCount(String proCount) {
		this.proCount = proCount;
	}
	
	/*public String[] getProductprom_array() {
		if(productprom != null){
			productprom_array = productprom.split("|");
			return productprom_array;
		}else{
			return null;
		}
	}
	public void setProductprom_array(String[] productprom_array) {
		this.productprom_array = productprom_array;
	}*/


	public void setIsgift(String isgift) {
		this.isgift = isgift;
	}

	public String getIsgift() {
		return isgift;
	}

}
