package com.ycc.redbabyserver.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ycc.redbabyserver.domain.Topic;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.TopicService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

/**
 * Created by Administrator on 2016/12/14.
 */
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("home收到请求");
        TopicService service = BasicFactory.getInstance(TopicService.class);
        List<Topic> home_banner = service.getBanner();
        if (home_banner == null) {
            CommonUtil.renderJson(response, GlobalParams.getError("当前没有专题信息"));
            return;
        }
        Map<String, Object> home = new HashMap<String, Object>();
        home.put("response", "home");
        List<Object> items = new ArrayList<Object>();
        for (Topic topic : home_banner) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", topic.getId());
            item.put("title", topic.getTitle());
            item.put("pic", topic.getPic());
            items.add(item);
        }
        home.put("home_banner", items);

        //把List集合转化成JSON格式
        JSONObject object = JSONObject.fromObject(home);
        //JSON格式变成字符串，以便发送
        String json = object.toString();
        //返回数据给客服端
        CommonUtil.renderJson(response, json);
    }
}
