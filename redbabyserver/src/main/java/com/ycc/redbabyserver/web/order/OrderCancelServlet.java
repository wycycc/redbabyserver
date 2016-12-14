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

public class OrderCancelServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrderService orderService = BasicFactory.getInstance(OrderService.class);
		
		String orderId = request.getParameter("orderId");
		String userid = request.getHeader("userid");
		
		System.out.println("订单id:"+orderId);
		System.out.println("userid:"+userid);
		
		if (StringUtils.isBlank(userid))
			userid = "2537a732-dccf-49c5-b562-82fe8095b2e3";
		
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
			return;
		}
		
		int cancelId = orderService.cancelOrderById(orderId, userid);
		if (cancelId < 1) {
			CommonUtil.renderJson(response, GlobalParams.getError("没有取消订单信息"));
			return;
		}
		System.out.println("取消订单");
		
		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("response", "ordercancel");
		

		JSONObject object = JSONObject.fromObject(orderMap);
		String json = object.toString();
		System.out.println("取消订单："+json);
		CommonUtil.renderJson(response, json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
