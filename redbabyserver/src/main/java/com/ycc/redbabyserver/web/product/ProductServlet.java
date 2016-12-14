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

import com.ycc.redbabyserver.domain.Property;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.ProService;
import com.ycc.redbabyserver.service.PropertyService;
import com.ycc.redbabyserver.utils.CommonUtil;

public class ProductServlet extends HttpServlet {

	private List<Property> propertyList;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProService service = BasicFactory.getInstance(ProService.class);
		PropertyService propertyservice = BasicFactory.getInstance(PropertyService.class);
		String pro_id = req.getParameter("pId");
		System.out.println(pro_id);
		com.ycc.redbabyserver.domain.Product pro = service.findProById(pro_id);
		propertyList = new ArrayList<Property>();//propertyservice.findAllPropertyById(Integer.valueOf(pro_id));
		pro.setProperties(propertyList);

		Map<String, Object> data = new HashMap<String, Object>();
		data.put("response", "product");
		data.put("product", pro);

		JSONObject jsonObject = JSONObject.fromObject(data);
		String json = jsonObject.toString();
		CommonUtil.renderJson(resp, json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
