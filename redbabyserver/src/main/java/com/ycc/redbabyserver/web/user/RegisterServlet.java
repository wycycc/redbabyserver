package com.ycc.redbabyserver.web.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.UserService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = BasicFactory.getInstance(UserService.class);
		
		// 1.获取用户名密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		// 2.非空判断
		if (username == null || "".equals(username.trim())) {

			CommonUtil.renderJson(response, GlobalParams.getError("用户名不能为空"));
			return;
		} else if (password == null || "".equals(password.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("密码不能为空"));
			return;
		}
		// 3.用户校验
		String id = null;
		try {
			id = service.register(username, password);
		} catch (Exception e) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户名已存在"));
			return;
		}
		if (id == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("注册失败"));
		} else {
			Map<String, Object> userinfo = new HashMap<String, Object>();
			userinfo.put("response", "register");
			Map<String, String> item = new HashMap<String, String>();
			item.put("userId", id);
			userinfo.put("userinfo", item);
			JSONObject object = JSONObject.fromObject(userinfo);
			String JSON = object.toString();
			CommonUtil.renderJson(response, JSON);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
