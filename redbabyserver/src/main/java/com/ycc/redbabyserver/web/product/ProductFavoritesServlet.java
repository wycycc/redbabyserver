package com.ycc.redbabyserver.web.product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;

import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.UserService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;

public class ProductFavoritesServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserService service = BasicFactory.getInstance(UserService.class);
		
		//获取参数，获取当前用户信息
		String userid = req.getHeader("userid");//从公共头获取userid
		
		//如果为空跳转到登录
		if(StringUtils.isBlank(userid)){
			CommonUtil.renderJson(resp, GlobalParams.getError("用户没登陆"));
			return;
		}
		
		String pId = req.getParameter("pId");
		System.out.println("pId:"+pId);
		System.out.println("userid"+userid);
		//添加
		service.addFavorite(userid,pId);
		
		
		//回复响应
			Map<String,Object> data = new HashMap<String, Object>();
			data.put("response", "product_favorites");
		
			JSONObject jsonObject = JSONObject.fromObject(data);
			String json = jsonObject.toString();
			CommonUtil.renderJson(resp, json);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
