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
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.CommentService;
import com.ycc.redbabyserver.utils.CommonUtil;

public class ProductCommentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		CommentService service = BasicFactory.getInstance(CommentService.class);
		//获取请求参数pId page pageNum
		String pId = req.getParameter("pId");
		String page = req.getParameter("page");
		String pageNum = req.getParameter("pageNum");
		
		
		//查询数据库
		List<Comment> list = service.getComments(pId,page,pageNum);
		
		//响应信息
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("response", "product_comment");
		data.put("comment", list);
		
		JSONObject jsonObject = JSONObject.fromObject(data);
		String json = jsonObject.toString();
		CommonUtil.renderJson(resp, json);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
