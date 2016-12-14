package com.ycc.redbabyserver.web.address;

import com.ycc.redbabyserver.domain.Address;
import com.ycc.redbabyserver.factory.BasicFactory;
import com.ycc.redbabyserver.service.AddressService;
import com.ycc.redbabyserver.utils.CommonUtil;
import com.ycc.redbabyserver.utils.GlobalParams;
import net.sf.json.JSONObject;
import org.apache.commons.lang.StringUtils;

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
@WebServlet(name = "AddressListServlet")
public class AddressListServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressService service = BasicFactory.getInstance(AddressService.class);
        String userid = request.getHeader("userid");
        String version = request.getParameter("Version");
        if (StringUtils.isBlank(userid))
            userid = "2537a732-dccf-49c5-b562-82fe8095b2e3";

        if (userid == null || "".equals(userid.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("用户id为空"));
            return;
        }
        if (version == null || "".equals(version.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("地址版本为空"));
            return;
        }

        List<Address> addresslist = service.getAddressList(userid);
        if (addresslist == null) {
            CommonUtil.renderJson(response, GlobalParams.getError("地址信息为空"));
            return;
        }
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "addresslist");
        List<Object> items = new ArrayList<Object>();
        for (Address address : addresslist) {
            Map<String, Object> item = new HashMap<String, Object>();
            item.put("id", address.getId());
            item.put("address_id", address.getAddress_id());
            item.put("name", address.getName());
            item.put("fixedtel", address.getFixedtel());
            item.put("provinceId", address.getProvinceid());
            item.put("phonenumber", address.getPhonenumber());
            item.put("cityId", address.getCityid());
            item.put("areaId", address.getId());
            item.put("areadetail", address.getAreaDetail());
            item.put("zipcode", address.getZipCode());
            items.add(item);
        }
        res.put("addresslist", items);

        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
