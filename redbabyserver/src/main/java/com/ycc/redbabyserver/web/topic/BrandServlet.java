package com.ycc.redbabyserver.web.topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.TopicService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

public class BrandServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TopicService service = BasicFactory.getInstance(TopicService.class);
		Map<String, List<com.ycc.redbabyserver.domain.Brand>> brandInfos = service.getBrand();
		if (brandInfos == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("推荐品牌为空"));
		} else {
			Map<String, Object> brand = new HashMap<String, Object>();
			brand.put("response", "brand");
			Set<String> keys = brandInfos.keySet();
			List<Object> list = new ArrayList<Object>();
			for (String key : keys) {
				Map<String, Object> map = new HashMap<String, Object>();
				List<Object> items = new ArrayList<Object>();
				map.put("key", key);
				List<com.ycc.redbabyserver.domain.Brand> values = brandInfos.get(key);
				for (com.ycc.redbabyserver.domain.Brand value : values) {
					Map<String, Object> item = new HashMap<String, Object>();
					item.put("id", value.getBrand_id());
					item.put("name", value.getName());
					item.put("pic", value.getPic());
					items.add(item);
				}
				map.put("value", items);
				list.add(map);
			}
			brand.put("brand", list);
			
			JSONObject object = JSONObject.fromObject(brand);
			String json = object.toString();
			CommonUtil.renderJson(response, json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
