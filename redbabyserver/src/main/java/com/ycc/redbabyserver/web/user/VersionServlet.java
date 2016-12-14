package com.ycc.redbabyserver.web.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.dao.UserDao;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

public class VersionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userdao = BasicFactory.getInstance(UserDao.class);
		List<com.ycc.redbabyserver.domain.Version> versionInfo = userdao.getVersion();
		if (versionInfo == null) {
			CommonUtil.renderJson(response, GlobalParams.getError("无当前版本信息"));
		} else {
			Map<String, Object> res = new HashMap<String, Object>();
			res.put("response", "version");
			List<Object> items = new ArrayList<Object>();
			for (com.ycc.redbabyserver.domain.Version version : versionInfo) {
				Map<String, Object> item = new HashMap<String, Object>();
				item.put("new", version.getIsnew());
				item.put("version", version.getVersion());
				item.put("force", version.getForce());
				item.put("url", version.getUrl());
				items.add(item);
			}
			res.put("version", items);
			JSONObject object = JSONObject.fromObject(res);
			String json = object.toString();
			CommonUtil.renderJson(response, json);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
