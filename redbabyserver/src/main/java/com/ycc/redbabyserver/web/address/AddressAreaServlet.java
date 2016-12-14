package com.ycc.redbabyserver.web.address;

import com.ycc.redbabyserver.domain.AddressArea;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
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
@WebServlet(name = "AddressAreaServlet")
public class AddressAreaServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressService service = BasicFactory.getInstance(AddressService.class);
        String areaid = request.getParameter("id");
        if (areaid == null || "".equals(areaid.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("地区id为空"));
            return;
        }
        List<AddressArea> areas = service.getAreaById(areaid);
        if (areas == null) {
            CommonUtil.renderJson(response, GlobalParams.getError("地址信息为空"));
            return;
        }
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "addressarea");
        List<Object> items = new ArrayList<Object>();
        for (AddressArea area : areas) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", area.getArea_id());
            item.put("value", area.getArea());
            items.add(item);
        }
        res.put("addressarea", items);

        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
