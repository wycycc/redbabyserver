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
import net.sf.json.JSONObject;

public class LimitbuyServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProService service = BasicFactory.getInstance(ProService.class);
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
		List<Product> productlist = service.getLimitbuy(pageNum, page);
		if (productlist == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("商品列表为空"));
		} else {
			Map<String, Object> favorites = new HashMap<String, Object>();
			favorites.put("response", "limitbuy");
			List<Object> items = new ArrayList<Object>();
			for (Product product : productlist) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("id", product.getPro_id());
				item.put("name", product.getName());
				item.put("pic", product.getPic());
				item.put("marketprice", product.getMarketPrice());
				item.put("price", product.getPrice());
				item.put("limitprice", product.getLimitPrice());
				item.put("lefttime", product.getLeftTime());
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
