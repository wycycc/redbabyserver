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

public class LogoutServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = BasicFactory.getInstance(UserService.class);
		String userid = request.getHeader("userid");
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
		}
		//获取数据
		boolean status = service.Logout(userid);
		System.out.println("注销成功？"+status);
		if (status) {
			Map<String, Object> logout = new HashMap<String, Object>();
			logout.put("response", "logout");
			JSONObject object = JSONObject.fromObject(logout);
			String json = object.toString();
			CommonUtil.renderJson(response, json);
		} else {
			CommonUtil.renderJson(response, GlobalParams.getError("注销失败"));
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
