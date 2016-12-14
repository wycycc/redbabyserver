package com.ycc.redbabyserver.web.address;

import com.ycc.redbabyserver.dao.AddressDao;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/12/14.
 */
@WebServlet(name = "AddressDefaultServlet")
public class AddressDefaultServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressDao addressdao = BasicFactory.getInstance(AddressDao.class);
        String addressid = request.getParameter("addressid");
        if (addressid == null || "".equals(addressid.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("地址id为空"));
            return;
        }
        int isdefault = addressdao.updateDefault(addressid);
        if (isdefault == 0) {
            CommonUtil.renderJson(response, GlobalParams.getError("默认地址设置失败"));
            return;
        }
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "addressdefault");

        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
