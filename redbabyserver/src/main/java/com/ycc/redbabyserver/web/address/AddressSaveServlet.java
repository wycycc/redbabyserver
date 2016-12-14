package com.ycc.redbabyserver.web.address;

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
@WebServlet(name = "AddressSaveServlet")
public class AddressSaveServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddressService service = BasicFactory.getInstance(AddressService.class);
        String userid = request.getHeader("userid");
        String addressid = request.getParameter("id");
        String name = request.getParameter("name");
        String phonenumber = request.getParameter("phonenumber");
        //String fixedtel = request.getParameter("fixedtel");
        //String areaid = request.getParameter("areaid");
        String areadetail = request.getParameter("areadetail");
        //String zipcode = request.getParameter("zipcode");
        //String provinceid = StringUtils.substring(areaid, 0, 3);
        //String cityid = StringUtils.substring(areaid, 0, 5);
        if (StringUtils.isBlank(userid))
            userid = "2537a732-dccf-49c5-b562-82fe8095b2e3";
        if (userid == null || "".equals(userid.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("用户id为空"));
            return;
        }
        if (name == null || "".equals(name.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("收货人姓名为空"));
            return;
        }
        if (phonenumber == null || "".equals(phonenumber.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("手机号码为空"));
            return;
        }
		/*if (fixedtel == null || "".equals(fixedtel.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("固定电话为空"));
			return;
		}*/
		/*if (areaid == null || "".equals(areaid.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("地区id为空"));
			return;
		}*/
        if (areadetail == null || "".equals(areadetail.trim())) {
            CommonUtil.renderJson(response, GlobalParams.getError("详情地址为空"));
            return;
        }
		/*if (zipcode == null || "".equals(zipcode.trim())) {
			CommonUtil.renderJson(response, GlobalParams.getError("邮编为空"));
			return;
		}*/
        if (addressid == null || "".equals(addressid.trim())) {//如果不带addressid则新增地址信息
            String id = service.saveAddress(userid, name, phonenumber,areadetail);
            if (id == null || "null".equals(id.trim())) {
                CommonUtil.renderJson(response, GlobalParams.getError("添加失败"));
                return;
            }
            addressid = id;
        } else {//如果带addressid则修改原地址信息
            System.out.println("修改地址");
            String id = service.updateAddress(userid, addressid, name, phonenumber, areadetail);
            System.out.println("addressid:"+addressid);
            System.out.println("name:"+name);
            System.out.println("phonenumber:"+phonenumber);
            System.out.println("areadetail:"+areadetail);
            if (id == null || "null".equals(id.trim())) {
                CommonUtil.renderJson(response, GlobalParams.getError("修改失败"));
                return;
            }
            addressid = id;
        }
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("response", "addresssave");
        List<Object> items = new ArrayList<Object>();
        Map<String, Object> item = new HashMap<String, Object>();
        item.put("id", addressid);
        item.put("name", name);
        item.put("phonenumber", phonenumber);
        //item.put("fixedtel", fixedtel);
        //item.put("provinceId", provinceid);
        //item.put("cityId", cityid);
        //item.put("areaId", areaid);
        item.put("areadetail", areadetail);
        //item.put("zipcode", zipcode);
        items.add(item);
        res.put("addresslist", items);

        JSONObject object = JSONObject.fromObject(res);
        String json = object.toString();
        CommonUtil.renderJson(response, json);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
