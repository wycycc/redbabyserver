package com.ycc.redbabyserver.web.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class ProductlistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProService service = BasicFactory.getInstance(ProService.class);
		
		//获取请求参数page  pageNum cId  orderby  filter
		String cId = req.getParameter("cId");
		String page = req.getParameter("page");
		String pageNum = req.getParameter("pageNum");
		String orderby = req.getParameter("orderby");
		String filter = req.getParameter("filter");
		
		
		if (StringUtils.isBlank(cId)) {
			CommonUtil.renderJson(resp, GlobalParams.getError("参数不正确"));
			return;
		}
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
		
		//使用参数查询数据库
		List<Product> list = service.getCateProductlist(cId,page,pageNum,orderby,filter);
		String totalCount = service.getCountByFilter(cId,filter);
		
		//返回信息
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("response", "category_productlist");
		data.put("productlist", list);
		data.put("list_count", totalCount);
		//data.put("list_filter", value);
		
		JsonConfig jc = new JsonConfig();
		
		JSONObject jsonObject = JSONObject.fromObject(data);
		String json = jsonObject.toString();
		CommonUtil.renderJson(resp, json);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
