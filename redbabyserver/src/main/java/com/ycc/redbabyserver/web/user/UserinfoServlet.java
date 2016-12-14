package com.ycc.redbabyserver.web.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.domain.User;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.UserService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

public class UserinfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService service = BasicFactory.getInstance(UserService.class);
		String userid = request.getHeader("userid");
		System.out.println(userid);
		if (userid == null || "".equals(userid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户ID为空"));
			return;
		}
		User user = service.getUserinfo(userid);
		System.out.println("test1");
		//System.out.println(userid);
		if (user == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("用户不存在"));
			System.out.println("用户不存在");
		} else {
			Map<String, Object> userinfo = new HashMap<String, Object>();
			userinfo.put("response", "userinfo");
			Map<String, Object> item = new HashMap<String, Object>();
			item.put("bonus", user.getBonus());
			item.put("level", user.getLevel());
			item.put("userId", user.getUserid());
			item.put("usersession", user.getUsersession());
			item.put("ordercount", user.getOrdercount());
			item.put("username", user.getUsername());
			item.put("favoritescount", user.getFavoritescount());
			userinfo.put("userinfo", item);
			System.out.println("test2");
			JSONObject object = JSONObject.fromObject(userinfo);
			String json = object.toString();
			CommonUtil.renderJson(response, json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
