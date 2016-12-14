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

import net.sf.json.JSONObject;

import com.ycc.redbabyserver.domain.Order;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.LogisticsService;
import com.ycc.redbabyserver.service.OrderService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class LogisticsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LogisticsService logistService = BasicFactory.getInstance(LogisticsService.class);
		String orderId = request.getParameter("orderId");
		String userid = request.getHeader("userid");
		
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
			return;
		}
		
		com.ycc.redbabyserver.domain.Logistics logist = logistService.findLogistByOrderId(orderId,userid);
		if (logist == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("当前没有订单信息"));
			return;
		}

		Map<String, Object> logistMap = new HashMap<String, Object>();
		logistMap.put("response","logistics");
		
		Map<String, Object> logiMap = new HashMap<String, Object>();
		List<Object> items = new ArrayList<Object>();
		items.add("2014-3-15 7:00到达上海");
		items.add("2014-3-15 9:00到达苏州");
		items.add("2014-3-16 9:00到达苏州");
		items.add("2014-3-16 18:00到达徐州");
		items.add("2014-3-17 9:00到达北京");
		logiMap.put("list",items);
		
		logiMap.put("expressway", logist.getExpressway());
		logiMap.put("logisticsid", logist.getLogisticsid());
		logiMap.put("logisticscorp", logist.getLogisticscorp());
		
		logistMap.put("logistics", logiMap);
		
		JSONObject object = JSONObject.fromObject(logistMap);
		String json = object.toString();
		CommonUtil.renderJson(response, json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
