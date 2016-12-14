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

import com.ycc.redbabyserver.dao.ProDao;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

public class HotProServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProDao prodao = BasicFactory.getInstance(ProDao.class);
		ProService service = BasicFactory.getInstance(ProService.class);
		String orderby = request.getParameter("orderby");
		String pageNum = request.getParameter("pageNum");
		String page = request.getParameter("page");
		if (page == null || "".equals(page.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("查询页数为空"));
			return;
		}
		if (pageNum == null || "".equals(pageNum.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("每页显示数为空"));
			return;
		}
		if (orderby == null || "".equals(orderby.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("排序方式为空"));
			return;
		}
		if ("sale_down".equals(orderby.trim())) {
			orderby = "sale desc";
		} else if ("price_up".equals(orderby.trim())) {
			orderby = "price asc";
		} else if ("price_down".equals(orderby.trim())) {
			orderby = "price desc";
		} else if ("comment_down".equals(orderby.trim())) {
			orderby = "comment desc";
		} else if ("shelves_down".equals(orderby.trim())) {
			orderby = "shelves desc";
		}
		List<Product> productlist = prodao.findHotProduct(orderby, pageNum, page);
		if (productlist == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("商品列表为空"));
		} else {
			Map<String, Object> favorites = new HashMap<String, Object>();
			favorites.put("response", "hotproduct");
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
