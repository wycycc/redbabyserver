package com.ycc.redbabyserver.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ycc.redbabyserver.service.ProService;
import org.apache.commons.lang.StringUtils;

import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.dao.TopicDao;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.mchange.v2.sql.filter.FilterStatement;

public class ProServiceImpl implements ProService {
	ProDao prodao = BasicFactory.getInstance(ProDao.class);
	TopicDao topicdao = BasicFactory.getInstance(TopicDao.class);

	@Override
	public List<Product> getProductlist(String keyword, String orderby,
			String pageNum, String page) {
		return prodao.findByKeyword(keyword, orderby, pageNum, page);
	}

	@Override
	public int getCount() {
		return prodao.getCount();
	}

	@Override
	public List<Product> getTopicPList(String topic_id, String orderby,
			String pageNum, String page, String order) {
		return prodao.findByTopicId(topic_id, orderby, pageNum, page, order);
	}

	@Override
	public List<Product> getBrandPList(String brand_id, String orderby,
			String pageNum, String page, String order) {
		return prodao.findByBrandId(brand_id, orderby, pageNum, page, order);
	}

	@Override
	public List<Product> getLimitbuy(String pageNum, String page) {
		return prodao.findLimitbuy(pageNum, page);
	}

	@Override
	public List<Product> getNewProduct(String orderby, String pageNum,
			String page) {
		return prodao.findNewProduct(orderby, pageNum, page);
	}

	
	@Override
	public List<Product> getCateProductlist(String cId, String page, String pageNum, String orderby, String filter) {
		if (StringUtils.isBlank(page)) {
			page = "1";
		}
		if (StringUtils.isBlank(pageNum)) {
			pageNum = "10";
		}
		
		if (StringUtils.isBlank(orderby)||"sale_down".equals(orderby.trim())) {
			orderby = "salesNum desc";
		}
		
		if("price_up".equals(orderby.trim())){
			orderby = "price asc";
		}else if("price_down".equals(orderby.trim())){
			orderby = "price desc";
		}else if("comment_down".equals(orderby.trim())){
			orderby = "commentCount desc";
		}else if("shelves_down".equals(orderby.trim())){
			orderby = "shelvesTime desc";
		}
		
		/*//处理筛选信息
		if(StringUtils.isBlank(filter)){
			filter = "0-0-0";
		}
		
		boolean flag = false;
		StringBuffer filterStr = new StringBuffer();
		String[] filters = filter.split("-");
		if(filters[0] != "0"){
			filterStr.append(" and property.id =" + filters[0]);
			flag = true;
		}
		if(filters[1] != "0"){
			filterStr.append(" and brand_id = " + filters[1]);
			flag = true;
		}
		if(filters[2] != "0"){
			filterStr.append("");
			flag = true;
		}
		if(flag)
			return prodao.findByCateIdAndFilter(cId, orderby, filterStr.toString());
		else*/
			return prodao.findByCateId(cId, page, pageNum ,orderby,filter);
	}
	
	@Override
	public String getCountByFilter(String cId, String filter) {
		return prodao.getCountByFilter(cId, filter);
	}

	@Override
	public Product findProById(String pro_id) {
		return prodao.findById(pro_id);
	}


	
}
