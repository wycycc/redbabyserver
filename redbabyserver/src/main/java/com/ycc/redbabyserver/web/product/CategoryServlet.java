package com.ycc.redbabyserver.web.product;

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
import com.ycc.redbabyserver.service.CateService;
import com.ycc.redbabyserver.utils.CommonUtil;

public class CategoryServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CateService service = BasicFactory.getInstance(CateService.class);

		// 获取请求版本号，与服务器对比
		String version = req.getParameter("version");
		
		//获取服务器版本号
		String serverVersion = service.getLastVersion()!=null? service.getLastVersion():"1.0";
		// 返回版本号
		Map<String, Object> data = new HashMap<String, Object>();
		//如果版本号相同，返回服务器端版本，返回一个空的category
		if(serverVersion.equals(version))
		{
			// 返回内容
			
			data.put("response", "category");
			data.put("version", serverVersion);
			data.put("category", new ArrayList<String>());
	
		}else{
			//版本号不相同，一般情况只能是服务器版本较新，查找所有分类信息并返回
			List<com.ycc.redbabyserver.domain.Category> category = service.getCateInfo();
			// 返回内容
			data.put("response", "category");
			data.put("version", serverVersion);
			data.put("category", category);
		}

		JSONObject jsonObject = JSONObject.fromObject(data);
		String json = jsonObject.toString();
		CommonUtil.renderJson(resp, json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);

	}

}
