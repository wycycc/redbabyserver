package com.ycc.redbabyserver.web.order;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.OrderService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class OrderListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = BasicFactory.getInstance(OrderService.class);
		
		String type = request.getParameter("type");
		String page = request.getParameter("page");
		String pageNum = request.getParameter("pageNum");
		String userid = request.getHeader("userid");
		System.out.println(type+page+pageNum);
		System.out.println("userid"+ userid);
		System.out.println("type:"+type);
		
		if (StringUtils.isBlank(userid))
			userid = "2537a732-dccf-49c5-b562-82fe8095b2e3";
		
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
			return;
		}
		
		List<Order> orderList = orderService.getOrderListByTypes(type,userid,page,pageNum);
		if (orderList == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("当前没有订单信息"));
			return;
		}

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("response", "orderlist");
		List<Object> items = new ArrayList<Object>();
		for (Order order : orderList) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("orderid", order.getOrder_uuid());
			item.put("status", order.getStatus());
			item.put("time", order.getTime());
			item.put("price", order.getPrice());
			item.put("flag", order.getFlag());
			items.add(item);
		}
		orderMap.put("orderlist", items);

		JSONObject object = JSONObject.fromObject(orderMap);
		String json = object.toString();
		System.out.println(json);
		CommonUtil.renderJson(response, json);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
