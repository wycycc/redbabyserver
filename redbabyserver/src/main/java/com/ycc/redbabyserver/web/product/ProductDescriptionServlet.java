package com.ycc.redbabyserver.web.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.ycc.redbabyserver.domain.Comment;
import com.ycc.redbabyserver.domain.Product;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CommentService;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.utils.CommonUtil;

public class ProductDescriptionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProService service = BasicFactory.getInstance(ProService.class);
		
		//获取请求信息
		String pro_id = req.getParameter("pId");

		//查数据库
		Product pro = service.findProById(pro_id);
		
		//响应信息
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("response", "product_description");
		data.put("productdesc",pro.getDescription());
		
		JSONObject jsonObject = JSONObject.fromObject(data);
		String json = jsonObject.toString();
		CommonUtil.renderJson(resp, json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
