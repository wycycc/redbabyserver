package com.ycc.redbabyserver.web.checkout;

import com.ycc.redbabyserver.utils.CommonUtil;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "InvoiceServlet")
public class InvoiceServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("id", "123");
        map.put("content", "服装");
        List<Map<String,String>> list = new ArrayList<Map<String,String>>();
        list.add(map);


        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "invoice");
        res.put("invoice", list);
        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
