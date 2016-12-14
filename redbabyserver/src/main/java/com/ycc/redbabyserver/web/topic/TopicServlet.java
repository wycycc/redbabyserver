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

import net.sf.json.JSONObject;

import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.TopicService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class TopicServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TopicService service = BasicFactory.getInstance(TopicService.class);
		List<com.ycc.redbabyserver.domain.Topic> home_banner = service.getBanner();
		if (home_banner == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("当前没有专题信息"));
			return;
		}
		Map<String, Object> home = new HashMap<String, Object>();
		home.put("response", "topic");
		List<Object> items = new ArrayList<Object>();
		for (com.ycc.redbabyserver.domain.Topic topic : home_banner) {
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("id", topic.getId());
			item.put("name", topic.getTitle());
			item.put("pic", topic.getPic());
			items.add(item);
		}
		home.put("topic", items);

		JSONObject object = JSONObject.fromObject(home);
		String json = object.toString();
		CommonUtil.renderJson(response, json);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
