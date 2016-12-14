package com.ycc.redbabyserver.web.topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

public class BrandPListServlet extends HttpServlet {

	private String order;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProService service = BasicFactory.getInstance(ProService.class);
		String id = request.getParameter("id");
		String orderby = request.getParameter("orderby");
		String pageNum = request.getParameter("pageNum");
		String page = request.getParameter("page");
		if (id == null || "".equals(id.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("品牌Id为空"));
			return;
		}
		if (page == null || "".equals(page.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("查询页数为空"));
			return;
		}
		if (pageNum == null || "".equals(pageNum.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("每页显示数为空"));
			return;
		}
		if (StringUtils.isBlank(orderby)) {
			orderby = "salesNum";
			order = "desc";
		}
		if("sale_down".equals(orderby.trim())){
			orderby = "salesNum";
			order = "desc";
		}else if("price_up".equals(orderby.trim())){
			orderby = "price";
			order = "asc";
		}else if("price_down".equals(orderby.trim())){
			orderby = "price";
			order = "desc";
		}else if("comment_down".equals(orderby.trim())){
			orderby = "commentCount";
			order = "desc";
		}else if("shelves_down".equals(orderby.trim())){
			orderby = "shelvesTime";
			order = "desc";
		}
		List<Product> productlist = service.getBrandPList(id, orderby, pageNum, page, order);
		if (productlist == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("商品列表为空"));
		} else {
			Map<String, Object> favorites = new HashMap<String, Object>();
			favorites.put("response", "brand_productlist");
			List<Object> items = new ArrayList<Object>();
			for (Product product : productlist) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("id", product.getPro_id());
				item.put("name", product.getName());
				item.put("pic", product.getPic());
				item.put("marketprice", product.getMarketPrice());
				item.put("price", product.getPrice());
				items.add(item);
			}
			favorites.put("productlist", items);
			favorites.put("list_count", service.getCount());

			JSONObject object = JSONObject.fromObject(favorites);
			String json = object.toString();
			CommonUtil.renderJson(response, json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
